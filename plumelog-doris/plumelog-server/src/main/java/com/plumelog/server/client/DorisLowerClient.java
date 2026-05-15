package com.plumelog.server.client;

import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import com.plumelog.core.client.AbstractServerClient;
import com.plumelog.core.util.StringUtils;
import com.plumelog.server.config.DorisEnvProperties;
import com.plumelog.server.entity.PlumeLog;
import com.plumelog.server.mapper.PlumeLogMapper;
import com.plumelog.server.service.PlumeLogService;
import com.plumelog.server.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * className：DorisLowerClient
 * description：DorisLowerClient
 *
 * @author Frank.chen
 * @version 1.0.0
 */
@Slf4j
public class DorisLowerClient extends AbstractServerClient {
    @Autowired
    private PlumeLogService plumeLogService;
    @Autowired
    private PlumeLogMapper plumeLogMapper;
    @Autowired
    private DorisEnvProperties dorisEnvProperties;

    private static List<String> excludeFields = List.of("positionNum", "time");

    @Override
    public void insertListLog(List<String> list, String baseIndex, String type) throws Exception {
        // 保存到doris中
        if (!CollectionUtils.isEmpty(list)) {
            List<PlumeLog> plumeLogs = new ArrayList<>();
            for (String s : list) {
                PlumeLog plumeLog = JSON.toJavaObject(JSON.parseObject(s), PlumeLog.class);
                if (StringUtils.isNotEmpty(type) && StringUtils.isEmpty(plumeLog.getLogType())) {
                    plumeLog.setLogType(type);
                }
                plumeLog.setBaseIndex(baseIndex);
                plumeLogs.add(plumeLog);
            }
            String streamUrl = String.format("http://%s:%s/api/%s/%s/_stream_load",
                    dorisEnvProperties.getHost(), dorisEnvProperties.getPort(), dorisEnvProperties.getDatabase(), dorisEnvProperties.getTable());

            HttpRequest.put(streamUrl)
                    .basicAuth(dorisEnvProperties.getUser(), dorisEnvProperties.getPasswd())
                    .header("Expect", "100-continue")
                    .header("label", UUID.randomUUID().toString())
                    .header("Content-Type", "text/plain; charset=UTF-8")
                    .header("format", "json")
                    // 导入json数组
                    .header("strip_outer_array", "true")
                    .body(JSON.toJSONString(plumeLogs))
                    .setFollowRedirects(true)
                    .execute();
        }
    }

    @Override
    public void insertListTrace(List<String> list, String baseIndex, String type) throws Exception {
    }


    @Override
    public boolean deleteIndex(String index) throws IOException {
        return plumeLogMapper.delete(Wrappers.<PlumeLog>lambdaQuery().eq(PlumeLog::getBaseIndex, index)) > 0;
    }

    @Override
    public String get(String url, String queryStr) throws Exception {
//        log.info("get-url:{}", url);
//        log.info("get-queryStr:{}", queryStr);
        return null;
    }

    @Override
    public String get(String indexStr, String queryStr, String from, String size, String type) throws Exception {
        if ("table".equals(type)) {
            return getDataString(queryStr, from, size);
        } else if ("chartData".equals(type)) {
            return getChartDataString(queryStr);
        } else {
            return getErrorChartString(queryStr);
        }
    }

    private String getErrorChartString(String queryStr) {
        QueryWrapper<PlumeLog> wrapper = Wrappers.query();
        conditionWrapper(wrapper, queryStr);
        List<Map<String, Object>> dataList = plumeLogMapper.countChart(wrapper);
        JSONArray buckets = new JSONArray();
        JSONObject aggregations = new JSONObject();
        headerChartData(dataList, buckets);
        aggregations.put("dataCount", Map.of("buckets", buckets));
        return JSON.toJSONString(Map.of("aggregations", aggregations));
    }

    private void headerChartData(List<Map<String, Object>> dataList, JSONArray buckets) {
        if (!CollectionUtils.isEmpty(dataList)) {
            Map<String, Map<String, Object>> hourMap = dataList.stream().collect(Collectors.toMap(data -> StringUtils.toString(data.get("hourStr")), data -> data));
            // 获取最小小时数
            Date minDate = hourMap.keySet().stream().map(hourStr -> DateUtil.parseStrToDate(hourStr, "yyyy-MM-dd HH:mm:ss.SSS")).min(Comparator.comparing(hour -> hour)).orElseGet(null);
            for (Map<String, Object> data : dataList) {
                String key = StringUtils.toString(data.get("hourStr"));
                Date date = DateUtil.parseStrToDate(key, "yyyy-MM-dd HH:mm:ss.SSS");
                addBucketsData(date, buckets, Integer.parseInt(StringUtils.toString(data.get("total"))));
                // 上一小时
                Date nextDate = DateUtils.addHours(date, -1);
                while (!hourMap.containsKey(DateUtil.parseDateToStr(nextDate, "yyyy-MM-dd HH:mm:ss.SSS"))
                        && nextDate.compareTo(minDate) > 0) {
                    addBucketsData(nextDate, buckets, 0);
                    nextDate = DateUtils.addHours(nextDate, -1);
                }
            }
        }
    }

    private void addBucketsData(Date date, JSONArray buckets, Integer total) {
        // 将 Date 转换为 Instant
        Instant instant = date.toInstant();
        // 使用UTC时区将 Instant 转换为 ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        // 定义一个包含毫秒数的 DateTimeFormatter,把时区时间进行转换
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        buckets.add(Map.of("key_as_string", zonedDateTime.format(formatter), "doc_count", total, "key", date.getTime()));
    }

    private String getChartDataString(String queryStr) {
        QueryWrapper<PlumeLog> wrapper = Wrappers.query();
        conditionWrapper(wrapper, queryStr);
        List<Map<String, Object>> dataList = plumeLogMapper.countChart(wrapper);
        JSONObject aggregations = new JSONObject();
        JSONArray buckets = new JSONArray();
        headerChartData(dataList, buckets);
        aggregations.put("2", Map.of("buckets", buckets));
        return JSON.toJSONString(Map.of("aggregations", aggregations));
    }

    private void conditionWrapper(QueryWrapper wrapper, String queryStr) {
        try {
            // 根据注册API配置的dataPath提取数据，处理查询条件
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(queryStr);
            ReadContext ctx = JsonPath.parse(document);
            net.minidev.json.JSONArray condition = ctx.read("$.query.bool.must");
            if (!CollectionUtils.isEmpty(condition)) {
                List<Object> matchPhrase = condition.stream().filter(o -> {
                    Map<String, Object> map = (Map<String, Object>) o;
                    Set<String> keySet = map.keySet();
                    return keySet.contains("match_phrase") || keySet.contains("match");
                }).collect(Collectors.toList());
                for (Object o : matchPhrase) {
                    Map<String, Object> map = (Map<String, Object>) o;
                    Map<String, Object> filedMap = (Map<String, Object>) map.get("match_phrase");
                    if (CollectionUtils.isEmpty(filedMap)) {
                        filedMap = (Map<String, Object>) map.get("match");
                    }
                    Map<String, Object> finalFiledMap = filedMap;
                    filedMap.keySet().stream().findFirst().ifPresent(filed -> {
                        Map<String, Object> queryValue = (Map<String, Object>) finalFiledMap.get(filed);
                        wrapper.eq(filed, queryValue.get("query"));
                    });
                }
                List<Object> queryString = condition.stream().filter(o -> {
                    Map<String, Object> map = (Map<String, Object>) o;
                    Set<String> keySet = map.keySet();
                    return keySet.contains("query_string");
                }).collect(Collectors.toList());
                for (Object o : queryString) {
                    Map<String, Object> map = (Map<String, Object>) o;
                    Map<String, Object> filedMap = (Map<String, Object>) map.get("query_string");
                    wrapper.like(StringUtils.toString(filedMap.get("default_field")), StringUtils.toString(filedMap.get("query")));
                }
                List<Object> range = condition.stream().filter(o -> {
                    Map<String, Object> map = (Map<String, Object>) o;
                    Set<String> keySet = map.keySet();
                    return keySet.contains("range");
                }).collect(Collectors.toList());
                for (Object o : range) {
                    Map<String, Object> map = (Map<String, Object>) o;
                    Map<String, Object> filedMap = (Map<String, Object>) map.get("range");
                    filedMap.keySet().stream().findFirst().ifPresent(filed -> {
                        Map<String, Object> queryValue = (Map<String, Object>) filedMap.get(filed);
                        wrapper.ge(filed, queryValue.get("gte"));
                        wrapper.lt(filed, queryValue.get("lt"));
                    });
                }
            }
        } catch (PathNotFoundException e) {
            log.warn("根据XPATH解析数据失败", e);
        }
    }

    private String getDataString(String queryStr, String from, String size) {
        QueryWrapper<PlumeLog> wrapper = Wrappers.query();
        conditionWrapper(wrapper, queryStr);
        // 处理排序
        JSONObject query = JSON.parseObject(queryStr);
        if (query.containsKey("sort")) {
            JSONArray sort = (JSONArray) query.get("sort");
            for (Object o : sort) {
                Map<String, Object> filedMap = (Map<String, Object>) o;
                filedMap.keySet().stream().forEach(filed -> {
                    // 排除掉ES核心概念字段
                    if (!excludeFields.contains(filed)) {
                        if ("asc".equalsIgnoreCase(StringUtils.toString(filedMap.get(filed)))) {
                            wrapper.orderByAsc(filed);
                        } else if ("desc".equalsIgnoreCase(StringUtils.toString(filedMap.get(filed)))) {
                            wrapper.orderByDesc(filed);
                        }
                    }
                });
            }
        }
        if (!"0".equals(size)) {
            long current = Long.valueOf(from) / Long.valueOf(size) + 1;
            IPage<PlumeLog> page = plumeLogService.page(new Page<>(current, Long.valueOf(size)), wrapper);
            JSONObject res = new JSONObject();
            JSONArray hits = new JSONArray();
            JSONObject total = new JSONObject();
            total.put("value", page.getTotal());
            total.put("relation", "eq");
            res.put("total", total);
            for (PlumeLog record : page.getRecords()) {
                hits.add(Map.of("_source", record));
            }
            res.put("hits", hits);
            return JSON.toJSONString(Map.of("hits", res));
        }
        return "";
    }

    @Override
    public String group(String indexStr, String queryStr) throws Exception {
        List<String> appNames = plumeLogMapper.getAppNames();
        JSONArray buckets = new JSONArray();
        JSONObject aggregations = new JSONObject();
        for (String appName : appNames) {
            buckets.add(Map.of("key", appName));
        }
        aggregations.put("dataCount", Map.of("buckets", buckets));
        return JSON.toJSONString(Map.of("aggregations", aggregations));
    }
}
