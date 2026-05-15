package com.xhb.dc.kettle.system.summary.model;

import lombok.Data;

/**
 * TaskRunSummary.
 */
@Data
public class TaskRunSummary {

    private String startDate;

    private String status;

    private String projectType;

    private int cnt;

}
