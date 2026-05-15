package com.xhb.dc.kettle.file.dto;

import lombok.Data;

import java.util.Date;

/**
 * 文件信息.
 *
 * @author songxiaolang
 * @since 2022-03-30 15:26
 */
@Data
public class FileSummary {
    /**
     * 最后修改时间.
     */
    private Date lastModified;

    /**
     * 文件大小.
     */
    private long size;

    /**
     * 文件key.
     */
    private String key;
}
