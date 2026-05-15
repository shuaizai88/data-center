package com.xhb.dc.kettle.portal.model.basicmodel.dto;

import java.util.List;
import lombok.Data;

/**
 * BasicModelAndMetaDataListDTO.
 */
@Data
public class BasicModelAndMetaDataListDTO {
    private BasicModelCopyDTO basicModelDTO;

    private List<BasicModelMetaDataDTO> basicModelMetaDataDTO;

}
