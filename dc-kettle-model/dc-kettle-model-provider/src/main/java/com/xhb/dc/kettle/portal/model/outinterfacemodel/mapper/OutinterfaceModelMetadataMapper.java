package com.xhb.dc.kettle.portal.model.outinterfacemodel.mapper;

import com.xhb.dc.kettle.portal.model.outinterfacemodel.dto.OutinterfaceBasicModelAndMetaDataDTO;
import com.xhb.dc.kettle.portal.model.outinterfacemodel.dto.OutinterfaceModelMetaDataCopyDTO;
import com.xhb.dc.kettle.portal.model.outinterfacemodel.entity.OutinterfaceModelMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutinterfaceModelMetadataMapper {
    int insert(OutinterfaceModelMetadata record);

    int insertSelective(OutinterfaceModelMetadata record);

    int deleteByModelName(@Param("outinterfaceModelName") String outinterfaceModelName);

    int insertOutinterfaceModelMetaData(@Param("list") List<OutinterfaceModelMetadata> list);

    int insertIntoBatch(List<OutinterfaceModelMetaDataCopyDTO> record);



    List<OutinterfaceBasicModelAndMetaDataDTO> selectBasicModelColumns(@Param("userId") String userId, @Param("basicModel") String basicModel);


}
