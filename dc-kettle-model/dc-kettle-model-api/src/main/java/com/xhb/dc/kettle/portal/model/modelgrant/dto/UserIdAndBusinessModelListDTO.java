package com.xhb.dc.kettle.portal.model.modelgrant.dto;

import java.util.List;
import lombok.Data;

/**
 * UserIdAndBusinessModelListDTO.
 */
@Data
public class UserIdAndBusinessModelListDTO {
    private String userId;

    private List<BusinessModelListDTO> listDTOS;

}
