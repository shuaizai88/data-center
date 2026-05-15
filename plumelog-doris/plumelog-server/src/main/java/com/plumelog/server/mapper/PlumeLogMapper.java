package com.plumelog.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plumelog.server.entity.PlumeLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (PlumeLog)表数据库访问层
 *
 * @author zhangdong
 * @since 2025-05-21 17:49:13
 */
@Mapper
public interface PlumeLogMapper extends BaseMapper<PlumeLog> {

    @MapKey("key_as_string")
    List<Map<String,Object>> countChart(@Param("ew") QueryWrapper<PlumeLog> ew);

    List<String> getAppNames();
}
