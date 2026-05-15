package com.xhb.dc.kettle.portal.model.datasource.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 授权数据源参数.
 */
@Data
@ApiModel(description = "授权数据源参数")
public class GrantDatasourceVo {

    private String dsId;

    private String[] userId;

}
