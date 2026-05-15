package com.xhb.dc.kettle.portal.model.modelgrant.mapper;

import com.xhb.dc.kettle.portal.model.modelgrant.entity.ModelUserGrant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelUserGrantMapper {
    int insert(ModelUserGrant record);

    int insertSelective(ModelUserGrant record);

    int insertModelUserGrants(@Param("list") List<ModelUserGrant> list);

    int deleteModelByUserId(@Param("userId") String userId);

    int deleteModelByUserName(@Param("userName") String userName);
}