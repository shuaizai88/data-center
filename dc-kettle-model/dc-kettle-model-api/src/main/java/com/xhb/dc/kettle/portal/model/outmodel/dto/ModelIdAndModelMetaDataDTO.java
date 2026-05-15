package com.xhb.dc.kettle.portal.model.outmodel.dto;

import java.util.List;
import lombok.Data;

/**
 * ModelIdAndModelMetaDataDTO.
 */
@Data
public class ModelIdAndModelMetaDataDTO {

    private String modelId;

    private List<OutModelMetaDataDTO> list;

}
