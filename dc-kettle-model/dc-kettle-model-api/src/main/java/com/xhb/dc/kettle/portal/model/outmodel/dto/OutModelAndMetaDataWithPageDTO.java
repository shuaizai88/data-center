package com.xhb.dc.kettle.portal.model.outmodel.dto;

import java.util.List;
import lombok.Data;

/**
 * OutModelAndMetaDataWithPageDTO.
 */
@Data
public class OutModelAndMetaDataWithPageDTO {
    private Long total;

    private List<OutModelAndMetaDataDTO> outModelAndMetaData;

}
