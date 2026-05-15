package com.xhb.dc.kettle.portal.model.businessmodel.dto;

import lombok.Data;

/**
 * BusinessModelMetaDataCopyDTO.
 */
@Data
public class BusinessModelMetaDataCopyDTO {

    private static final long serialVersionUID = 1L;

    private String businessModelName;

    private String columnName;

    private String columnSerial;

    private String customColumnName;

    private String columnEtlSql;

}
