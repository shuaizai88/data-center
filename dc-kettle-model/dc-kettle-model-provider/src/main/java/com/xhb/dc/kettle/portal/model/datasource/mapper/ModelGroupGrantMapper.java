package com.xhb.dc.kettle.portal.model.datasource.mapper;

import com.xhb.dc.kettle.portal.model.datasource.entity.ModelGroupGrant;

public interface ModelGroupGrantMapper {
    int insert(ModelGroupGrant record);

    int insertSelective(ModelGroupGrant record);
}