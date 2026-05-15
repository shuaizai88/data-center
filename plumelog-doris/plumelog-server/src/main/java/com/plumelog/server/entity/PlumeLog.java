package com.plumelog.server.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * (PlumeLog)实体类
 *
 * @author zhangdong
 * @since 2025-05-21 17:49:14
 */
@TableName(value = "plume_log_duplicate", autoResultMap = true)
public class PlumeLog {
    /**
     * 日志类型
     */
    @TableField("logType")
    private String logType;

    /**
     * 日志时间
     */
    @TableField("dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Date dateTime;

    /**
     * 请求唯一标识
     */
    @TableField("traceId")
    private String traceId;

    /**
     * 方法
     */
    @TableField("method")
    private String method;

    /**
     * 应用名称
     */
    @TableField("appName")
    private String appName;

    /**
     * 服务名称
     */
    @TableField("serverName")
    private String serverName;

    /**
     * 类名称
     */
    @TableField("className")
    private String className;

    /**
     * 环境
     */
    @TableField("env")
    private String env;

    /**
     * 日志内容
     */
    @TableField("content")
    private String content;

    /**
     * 线程名称
     */
    @TableField("threadName")
    private String threadName;

    @TableField("spanId")
    private String spanId;

    @TableField("dtTime")
    private Long dtTime;

    /**
     * 日志等级
     */
    @TableField("logLevel")
    private String logLevel;

    /**
     * 索引
     */
    @TableField("base_index")
    private String baseIndex;

    @TableField("seq")
    private Integer seq;


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getBaseIndex() {
        return baseIndex;
    }

    public void setBaseIndex(String baseIndex) {
        this.baseIndex = baseIndex;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public Long getDtTime() {
        return dtTime;
    }

    public void setDtTime(Long dtTime) {
        this.dtTime = dtTime;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlumeLog;
    }
}
