package com.xhb.dc.kettle.system.config.mapper;

import com.xhb.dc.kettle.system.config.entity.DpPortalWebConfig;

import java.util.List;

/**
 * DpPortalWebConfigMapper.
 */
public interface DpPortalWebConfigMapper {
    /**
     * deleteByPrimaryKey.
     *
     * @param key key
     * @return int
     */
    int deleteByPrimaryKey(String key);

    /**
     * DpPortalWebConfig.
     *
     * @param record record
     * @return int
     */
    int insert(DpPortalWebConfig record);

    /**
     * insertSelective.
     *
     * @param record insertSelective
     * @return int
     */
    int insertSelective(DpPortalWebConfig record);

    /**
     * selectByPrimaryKey.
     *
     * @param key key
     * @return DpPortalWebConfig
     */
    DpPortalWebConfig selectByPrimaryKey(String key);

    /**
     * DpPortalWebConfig.
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(DpPortalWebConfig record);

    /**
     * DpPortalWebConfig.
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(DpPortalWebConfig record);

    /**
     * selectAll.
     *
     * @return selectAll
     */
    List<DpPortalWebConfig> selectAll();

}
