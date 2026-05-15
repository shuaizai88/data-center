package com.xhb.dc.kettle.portal.model.businessmodel.dto;

import java.util.List;
import lombok.Data;

/**
 * BusinessModelAndMetaListDTO.
 */
@Data
public class BusinessModelAndMetaListDTO {

    private BusinessModelAndBasicModelName businessModelAndBasicModelName;

    private List<BusinessModelMetaDataCopyDTO> list;

}
