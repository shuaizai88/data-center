package com.xhb.dc.kettle.system.gateway.service;

import com.xhb.dc.kettle.core.util.JsonUtils;
import com.xhb.dc.kettle.system.gateway.MsgType;
import com.xhb.dc.kettle.system.gateway.dto.DpGatewayRouteDTO;
import com.xhb.dc.kettle.system.gateway.dto.DpGatewayRouteMsgDTO;
import com.xhb.dc.kettle.system.gateway.entity.DpGatewayRoute;
import com.xhb.dc.kettle.system.gateway.mapper.DpGatewayRouteMapper;
import com.xhb.dc.kettle.system.gateway.vo.DpGatewayRouteVO;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * GatewayRouteService.
 *
 * @author gavin
 * @since 2020/6/12 5:20 下午
 */
@Service
public class GatewayRouteService {

    private final DpGatewayRouteMapper dpGatewayRouteMapper;

    private final RedisPublisherService redisPublisherService;

    @Value("${gateway.route.channel:gateway_route}")
    private String gatewayRouteChannel;

    @Autowired
    public GatewayRouteService(DpGatewayRouteMapper dpGatewayRouteMapper, RedisPublisherService redisPublisherService) {
        this.dpGatewayRouteMapper = dpGatewayRouteMapper;
        this.redisPublisherService = redisPublisherService;
    }

    /**
     * 增加或者更新规则.
     *
     * @param dpGatewayRouteVO DpGatewayRouteVO
     * @return DpGatewayRouteDTO
     */
    public DpGatewayRouteDTO upsert(DpGatewayRouteVO dpGatewayRouteVO) {
        DpGatewayRoute record = new DpGatewayRoute();
        BeanUtils.copyProperties(dpGatewayRouteVO, record);

        if (dpGatewayRouteMapper.selectByPrimaryKey(dpGatewayRouteVO.getId()) != null) {
            record.setUpdateTime(new Date());
            record.setStatus(1);
            dpGatewayRouteMapper.updateByPrimaryKeySelective(record);
        } else {
            record.setCreateTime(new Date());
            record.setStatus(1);
            dpGatewayRouteMapper.insert(record);
        }

        final DpGatewayRouteDTO result = new DpGatewayRouteDTO();
        BeanUtils.copyProperties(record, result);

        // 发送redis消息
        redisPublisherService.pubMsg(gatewayRouteChannel, JsonUtils.toString(new DpGatewayRouteMsgDTO(MsgType.UPSET, result)));

        return result;
    }

    /**
     * deleteByPrimaryKey.
     *
     * @param id id
     * @return int
     */
    public int deleteByPrimaryKey(String id) {
        final int i = dpGatewayRouteMapper.deleteByPrimaryKey(id);
        DpGatewayRouteDTO dpGatewayRouteDTO = new DpGatewayRouteDTO();
        dpGatewayRouteDTO.setId(id);
        dpGatewayRouteDTO.setStatus(1);

        // 发送redis消息
        redisPublisherService.pubMsg(gatewayRouteChannel, JsonUtils.toString(new DpGatewayRouteMsgDTO(MsgType.DELETE, dpGatewayRouteDTO)));
        return i;
    }

    /**
     * selectAll.
     *
     * @return list
     */
    public List<DpGatewayRouteDTO> selectAll() {
        return dpGatewayRouteMapper.selectAll();
    }

}
