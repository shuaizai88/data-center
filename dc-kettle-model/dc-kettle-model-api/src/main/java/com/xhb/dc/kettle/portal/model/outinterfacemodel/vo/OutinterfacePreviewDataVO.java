package com.xhb.dc.kettle.portal.model.outinterfacemodel.vo;

import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import com.xhb.dc.kettle.portal.model.common.entity.ModelFilterVO;
import java.util.List;
import lombok.Data;

/**
 * OutinterfacePreviewDataVO.
 */
@Data
public class OutinterfacePreviewDataVO {
    private String basicModelId;

    private List<ModelFilterVO> modelFilterVOS;

    private List<BasicModelMetaDataVO> modelMetaDataVOS;

}
