package com.xhb.dc.kettle.portal.model.basicmodel.dto;

import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 字段信息对象.
 */
@ApiModel(description = "字段信息对象")
@Data
public class AllColumnDTO extends BasicModelMetaDataVO {

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "过滤sql")
    private String columnEtlSql;
}
