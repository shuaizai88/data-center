package com.xhb.dc.kettle.system.config.service.impl;

import com.xhb.dc.kettle.system.config.entity.DpPortalSysconf;
import com.xhb.dc.kettle.system.config.mapper.DpPortalSysconfMapper;
import com.xhb.dc.kettle.system.config.service.DpPortalSysconfService;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * DpPortalSysconfService.
 */
@Service
public class DpPortalSysconfServiceImpl implements DpPortalSysconfService {

    @Resource
    private DpPortalSysconfMapper dpPortalSysconfMapper;

    @Override
    public int deleteByPrimaryKey(String paramKey) {
        return dpPortalSysconfMapper.deleteByPrimaryKey(paramKey);
    }

    @Override
    public int insert(DpPortalSysconf record) {
        return dpPortalSysconfMapper.insert(record);
    }

    @Override
    public int insertSelective(DpPortalSysconf record) {
        return dpPortalSysconfMapper.insertSelective(record);
    }

    @Override
    public DpPortalSysconf selectByPrimaryKey(String paramKey) {
        return dpPortalSysconfMapper.selectByPrimaryKey(paramKey);
    }

    @Override
    public int updateByPrimaryKeySelective(DpPortalSysconf record) {
        return dpPortalSysconfMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DpPortalSysconf record) {
        return dpPortalSysconfMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<DpPortalSysconf> selectByType(String paramType) {
        return dpPortalSysconfMapper.selectByType(paramType);
    }

}
