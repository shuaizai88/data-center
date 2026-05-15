package com.xhb.dc.kettle.portal.model.basicmodel.dto;

import java.util.List;
import lombok.Data;

/**
 * BasicModelAndColumnsDTO.
 */
@Data
public class BasicModelAndColumnsDTO {

    private BasicModelCopyDTO basicModelCopyDTO;

    private List<AllColumnDTO> list;

}
