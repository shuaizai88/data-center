package com.xhb.dc.kettle.portal.model.basicmodel.dto;

import com.xhb.dc.kettle.portal.model.common.entity.ModelFilterVO;

import java.util.List;
import lombok.Data;

/**
 * ModelNameAndModelFilterDTO.
 */
@Data
public class ModelNameAndModelFilterDTO {

    private String modelName;

    private List<ModelFilterVO> modelFilterVOS;

}
