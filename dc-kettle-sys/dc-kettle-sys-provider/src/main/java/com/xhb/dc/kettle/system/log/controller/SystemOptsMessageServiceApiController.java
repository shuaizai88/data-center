package com.xhb.dc.kettle.system.log.controller;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.core.util.UUIDUtils;
import com.xhb.dc.kettle.system.log.api.SystemOptsMessageServiceApi;
import com.xhb.dc.kettle.system.log.entity.DpSystemOptsMessage;
import com.xhb.dc.kettle.system.log.vo.SystemOptsMessageVo;
import com.xhb.dc.kettle.system.summary.dto.SystemOptsMessageDTO;
import com.xhb.dc.kettle.system.log.service.DpSystemOptsMessageService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemOptsMessageServiceApiController.
 */
@RestController
@RequestMapping("/systemOptsMessage")
public class SystemOptsMessageServiceApiController implements SystemOptsMessageServiceApi {
    private final DpSystemOptsMessageService systemOptsMessageService;

    @Autowired
    public SystemOptsMessageServiceApiController(DpSystemOptsMessageService systemOptsMessageService) {
        this.systemOptsMessageService = systemOptsMessageService;
    }

    @Override
    public Result<SystemOptsMessageDTO, Object> add(SystemOptsMessageVo systemOptsMessageVo) {
        DpSystemOptsMessage dpSystemOptsMessage = new DpSystemOptsMessage();
        dpSystemOptsMessage.setOpsId(UUIDUtils.generateUUID32());
        dpSystemOptsMessage.setCreateTime(new Date());
        dpSystemOptsMessage.setOpsItemId(systemOptsMessageVo.getOpsItemId());
        dpSystemOptsMessage.setOpsItemName(systemOptsMessageVo.getOpsItemName());
        dpSystemOptsMessage.setOpsItemType(systemOptsMessageVo.getOpsItemType());
        dpSystemOptsMessage.setOpsToUserId(systemOptsMessageVo.getOpsToUserId());
        dpSystemOptsMessage.setOpsToUserName(systemOptsMessageVo.getOpsToUserName());
        dpSystemOptsMessage.setOpsUserId(systemOptsMessageVo.getOpsUserId());
        dpSystemOptsMessage.setOpsUserName(systemOptsMessageVo.getOpsUserName());
        dpSystemOptsMessage.setOpsType(systemOptsMessageVo.getOpsType());
        dpSystemOptsMessage.setOpsLevel(1);
        systemOptsMessageService.insert(dpSystemOptsMessage);
        SystemOptsMessageDTO systemOptsMessageDTO = new SystemOptsMessageDTO();
        BeanUtils.copyProperties(dpSystemOptsMessage, systemOptsMessageDTO);
        return Result.success(systemOptsMessageDTO);
    }

    @Override
    public Result<List<SystemOptsMessageDTO>, Object> selectLast7DayMessage(String userId) {
        List<SystemOptsMessageDTO> systemOptsMessageDTOS = systemOptsMessageService.selectLast7DayMessage(userId);
        return Result.success(systemOptsMessageDTOS);
    }
}
