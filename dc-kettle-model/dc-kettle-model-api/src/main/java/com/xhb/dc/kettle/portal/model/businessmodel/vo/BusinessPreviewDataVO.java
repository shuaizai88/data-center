package com.xhb.dc.kettle.portal.model.businessmodel.vo;

import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import com.xhb.dc.kettle.portal.model.common.entity.ModelFilterVO;
import java.util.List;
import lombok.Data;

/**
 * BusinessPreviewDataVO.
 */
@Data
public class BusinessPreviewDataVO {
    private String basicModelId;

    private List<ModelFilterVO> modelFilterVOS;

    private List<BasicModelMetaDataVO> modelMetaDataVOS;

}
