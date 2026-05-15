package com.xhb.dc.kettle.system.gateway.mapper;

import com.xhb.dc.kettle.system.gateway.dto.DpGatewayRouteDTO;
import com.xhb.dc.kettle.system.gateway.entity.DpGatewayRoute;
import java.util.List;

/**
 * DpGatewayRouteMapper.
 */
public interface DpGatewayRouteMapper {
    /**
     * deleteByPrimaryKey.
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert.
     *
     * @param record record
     * @return int
     */
    int insert(DpGatewayRoute record);

    /**
     * insertSelective.
     *
     * @param record record
     * @return int
     */
    int insertSelective(DpGatewayRoute record);

    /**
     * selectByPrimaryKey.
     *
     * @param id id
     * @return selectByPrimaryKey
     */
    DpGatewayRoute selectByPrimaryKey(String id);

    /**
     * updateByPrimaryKeySelective.
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(DpGatewayRoute record);

    /**
     * updateByPrimaryKey.
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(DpGatewayRoute record);

    /**
     * selectAll.
     *
     * @return list
     */
    List<DpGatewayRouteDTO> selectAll();
}

