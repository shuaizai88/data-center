package com.xhb.dc.kettle.portal.model.businessmodel.mapper;

import com.xhb.dc.kettle.portal.model.businessmodel.dto.BasicModelAndMetaDataDTO;
import com.xhb.dc.kettle.portal.model.businessmodel.dto.BusinessModelMetaDataCopyDTO;
import com.xhb.dc.kettle.portal.model.businessmodel.entity.BusinessModelMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessModelMetadataMapper {
    int insert(BusinessModelMetadata record);

    int insertSelective(BusinessModelMetadata record);

    int deleteByModelName(@Param("businessModelName") String businessModelName);

    int insertBusinessModelMetaData(@Param("list") List<BusinessModelMetadata> list);

    int insertIntoBatch(List<BusinessModelMetaDataCopyDTO> record);



    List<BasicModelAndMetaDataDTO> selectBasicModelColumns(@Param("userId") String userId, @Param("basicModel") String basicModel);


}