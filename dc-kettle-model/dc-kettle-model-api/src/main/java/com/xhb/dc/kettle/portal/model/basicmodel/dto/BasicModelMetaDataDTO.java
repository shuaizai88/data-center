package com.xhb.dc.kettle.portal.model.basicmodel.dto;

import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import lombok.Data;

/**
 * BasicModelMetaDataDTO.
 */
@Data
public class BasicModelMetaDataDTO extends BasicModelMetaDataVO {

    private String columnEtlSql;

}
