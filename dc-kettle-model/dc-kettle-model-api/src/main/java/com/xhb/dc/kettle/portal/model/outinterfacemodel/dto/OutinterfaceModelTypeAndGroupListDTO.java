package com.xhb.dc.kettle.portal.model.outinterfacemodel.dto;

import java.util.List;
import lombok.Data;

/**
 * OutinterfaceModelTypeAndGroupListDTO.
 */
@Data
public class OutinterfaceModelTypeAndGroupListDTO {

    private String groupTypeName;

    private List<OutinterfaceModelAndGroupListDTO> outinterfaceModelAndGroupListDTOS;

}
