# 基于plumelog的日志记录系统，将日志写到doris里并且从doris里读取.
doris建表语句    
CREATE TABLE `plume_log_duplicate` (
  `dateTime` DATETIME NULL COMMENT '日志时间',
  `traceId` VARCHAR(765) NULL COMMENT '请求唯一标识',
  `dtTime` BIGINT NULL,
  `seq` INT NULL,
  `logType` VARCHAR(60) NULL COMMENT '日志类型',
  `method` VARCHAR(384) NOT NULL COMMENT '方法',
  `appName` VARCHAR(765) NULL COMMENT '应用名称',
  `serverName` VARCHAR(765) NULL COMMENT '服务名称',
  `className` VARCHAR(765) NULL COMMENT '类名称',
  `env` VARCHAR(765) NULL COMMENT '环境',
  `content` TEXT NULL COMMENT '日志内容',
  `threadName` VARCHAR(96) NULL COMMENT '线程名称',
  `spanId` VARCHAR(32) NULL,
  `logLevel` VARCHAR(32) NULL COMMENT '日志等级',
  `base_index` VARCHAR(64) NULL
) ENGINE=OLAP
DUPLICATE KEY(`dateTime`, `traceId`, `dtTime`, `seq`)
DISTRIBUTED BY HASH(`traceId`) BUCKETS AUTO
PROPERTIES (
"replication_allocation" = "tag.location.default: 1")