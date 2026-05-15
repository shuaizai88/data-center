package com.xhb.dc.kettle.portal.model.modelgrant.mapper;

import com.xhb.dc.kettle.portal.model.modelgrant.entity.ModelGroupBusinessModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelGroupBusinessModelMapper {
    int insert(ModelGroupBusinessModel record);

    int insertSelective(ModelGroupBusinessModel record);

    /***
     * 关联授权组和业务模型
     * @param list
     * @return
     */
    int addModelGroupBusinessModels(@Param("list") List<ModelGroupBusinessModel> list);


    int deleteByGroupName(@Param("groupName") String groupName);
}