package com.xhb.dc.kettle.system.log.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.core.util.UUIDUtils;
import com.xhb.dc.kettle.system.common.utils.BaseController;
import com.xhb.dc.kettle.system.log.api.LogServiceApi;
import com.xhb.dc.kettle.system.log.dto.LogDTO;
import com.xhb.dc.kettle.system.log.entity.DpPortalLog;
import com.xhb.dc.kettle.system.log.task.AsyncLog;
import com.xhb.dc.kettle.system.log.vo.LogVO;
import com.xhb.dc.kettle.system.log.service.DpPortalLogService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LogServiceApiController.
 */
@RestController
@RequestMapping("/log")
public class LogServiceApiController extends BaseController<LogDTO> implements LogServiceApi {

    private final AsyncLog asyncLog;

    private final DpPortalLogService dpPortalLogService;

    @Autowired
    public LogServiceApiController(AsyncLog asyncLog, DpPortalLogService dpPortalLogService) {
        this.asyncLog = asyncLog;
        this.dpPortalLogService = dpPortalLogService;
    }

    @Override
    public Result<LogDTO, Object> add(LogVO logVO) {

        DpPortalLog dpPortalLog = new DpPortalLog();
        dpPortalLog.setLogId(UUIDUtils.nextId());
        dpPortalLog.setExcTime(logVO.getExcTime());
        dpPortalLog.setReqIp(logVO.getReqIp());
        dpPortalLog.setReqSize(logVO.getReqSize());
        dpPortalLog.setReqTime(logVO.getReqTime());
        dpPortalLog.setReqUri(logVO.getReqUri());
        dpPortalLog.setServerName(logVO.getServerName());
        LogDTO logDTO = new LogDTO();
        BeanUtils.copyProperties(dpPortalLog, logDTO);
        asyncLog.put(dpPortalLog);
        return Result.success(logDTO);
    }

    @Override
    public Result<Integer, Object> batchAdd(List<LogVO> logs) {
        return Result.success(dpPortalLogService.batchInsertVO(logs));
    }

    @Override
    public Result getLogsByReqTimePage(String pageSize, String curPage, Date startDate, Date endDate, String userName) {
        Page page = this.initPage(pageSize, curPage);
        PageInfo<LogDTO> logDTOPageInfo = dpPortalLogService.selectByReqTime(startDate, endDate, userName, page);
        return Result.success(logDTOPageInfo);
    }
}
