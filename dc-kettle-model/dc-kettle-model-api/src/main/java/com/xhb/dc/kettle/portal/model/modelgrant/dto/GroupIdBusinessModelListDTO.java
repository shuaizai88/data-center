package com.xhb.dc.kettle.portal.model.modelgrant.dto;

import java.util.List;
import lombok.Data;


/**
 * GroupIdBusinessModelListDTO.
 */
@Data
public class GroupIdBusinessModelListDTO {
    private String groupid;

    private List<BusinessModelListDTO> businessModelListDTOS;
}
