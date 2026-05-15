package com.xhb.dc.kettle.portal.model.modelgrant.mapper;

import com.xhb.dc.kettle.portal.model.modelgrant.entity.ModelGroupUserGrant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelGroupUserGrantMapper {
    int insert(ModelGroupUserGrant record);

    int insertSelective(ModelGroupUserGrant record);

    int insertModelGroupUserGrants(@Param("list") List<ModelGroupUserGrant> list);

    int deleteModelGroupByUserId(@Param("userId") String userId);

    int deleteModelGroupByUserName(@Param("userName") String userName);

}