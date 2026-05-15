package com.xhb.dc.kettle.system.config.controller;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.system.config.api.PortalSysconfApi;
import com.xhb.dc.kettle.system.config.dto.PortalSysconfDTO;
import com.xhb.dc.kettle.system.config.entity.DpPortalSysconf;
import com.xhb.dc.kettle.system.config.service.DpPortalSysconfService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PortalSysconfApiController.
 */
@RestController
@RequestMapping("/portalSysconf")
public class PortalSysconfApiController implements PortalSysconfApi {

    @Resource
    private DpPortalSysconfService dpPortalSysconfService;

    @Override
    public Result<List<PortalSysconfDTO>, Object> getPortalSysconfByType(String paramType) {
        List<DpPortalSysconf> dpPortalSysconfList = dpPortalSysconfService.selectByType(paramType);
        List<PortalSysconfDTO> list = new ArrayList<>();
        dpPortalSysconfList.forEach(o -> {
            PortalSysconfDTO portalSysconfDTO = new PortalSysconfDTO();
            BeanUtils.copyProperties(o, portalSysconfDTO);
            list.add(portalSysconfDTO);
        });
        return Result.success(list);
    }
}
