package com.xhb.dc.kettle.portal.model.basicmodel.mapper;

import com.xhb.dc.kettle.portal.model.basicmodel.dto.AllColumnDTO;
import com.xhb.dc.kettle.portal.model.basicmodel.dto.BasicModelMetaDataDTO;
import com.xhb.dc.kettle.portal.model.basicmodel.dto.SelectModelNameAndColumnCountDTO;
import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import com.xhb.dc.kettle.portal.model.basicmodel.entity.BasiceModelMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasiceModelMetadataMapper {
    int insert(BasiceModelMetadata record);

    int insertSelective(BasiceModelMetadata record);

    int deleteByModelName(String modelName);

    List<SelectModelNameAndColumnCountDTO> selectBusinessModelNameAndColumnCount(@Param("list") List<String> modelName);

    int insertBasicModelMetaData(@Param("list") List<BasicModelMetaDataVO> list);


    int insertIntoBatch(@Param("list") List<BasicModelMetaDataDTO> record);

    int insertAllColunms(@Param("list") List<AllColumnDTO> list);
}