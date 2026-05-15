package com.xhb.dc.kettle.portal.model.outmodel.mapper;

import com.xhb.dc.kettle.portal.model.outmodel.dto.ModelIdAndModelMetaDataDTO;
import com.xhb.dc.kettle.portal.model.outmodel.dto.OutModelProjectIdAndNamesDTO;
import com.xhb.dc.kettle.portal.model.outmodel.entity.OutModelMetaData;
import com.xhb.dc.kettle.portal.model.outmodel.vo.OutModelMetaDataVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutModelMetaDataMapper {
    int insert(OutModelMetaData record);

    int insertSelective(OutModelMetaData record);

    int deleteOutModelMetaDataByModelName(@Param("list") List<String> modelName);

    int deleteOutModelMetaDataByOne(@Param("modelName")String modelName);

    int batchInsertOutModelMeta(@Param("list") List<OutModelMetaDataVO> list);

    List<ModelIdAndModelMetaDataDTO> selectModelMeataDataList(@Param("list") List<String> modeIds);

    List<OutModelProjectIdAndNamesDTO> selectProjects(@Param("userId") String userId);


}