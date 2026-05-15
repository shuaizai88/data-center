package com.xhb.dc.kettle.portal.model.basicmodel.vo;

import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import com.xhb.dc.kettle.portal.model.common.entity.ModelFilterVO;

import java.util.List;
import lombok.Data;

/**
 * TestPreviewVO.
 */
@Data
public class TestPreviewVO {
    private String datasourceId;

    private List<BasicModelMetaDataVO> metaDatas;

    private List<ModelFilterVO> modelFilter;

    private String tableName;

}
