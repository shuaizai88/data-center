package com.xhb.dc.kettle.system.user.service.impl;

import com.xhb.dc.kettle.system.user.entity.DpPortalRoleResource;
import com.xhb.dc.kettle.system.user.mapper.DpPortalRoleResourceMapper;
import com.xhb.dc.kettle.system.user.service.DpPortalRoleResourceService;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * DpPortalRoleResourceServiceImpl.
 */
@Service
public class DpPortalRoleResourceServiceImpl implements DpPortalRoleResourceService {

    @Resource
    private DpPortalRoleResourceMapper dpPortalRoleResourceMapper;

    @Override
    public int insert(DpPortalRoleResource record) {
        return dpPortalRoleResourceMapper.insert(record);
    }

    @Override
    public int insertSelective(DpPortalRoleResource record) {
        return dpPortalRoleResourceMapper.insertSelective(record);
    }

    @Override
    public int deleteByRoleId(String roleId) {
        return dpPortalRoleResourceMapper.deleteByRoleId(roleId);
    }

    @Override
    public int batchInsert(List<DpPortalRoleResource> records) {
        return dpPortalRoleResourceMapper.batchInsert(records);
    }

    @Override
    public int deleteByRoleIds(List<String> roleIds) {
        return dpPortalRoleResourceMapper.deleteByRoleIds(roleIds);
    }

    @Override
    public int deleteByResId(String resourceId) {
        return dpPortalRoleResourceMapper.deleteByResId(resourceId);
    }

}
