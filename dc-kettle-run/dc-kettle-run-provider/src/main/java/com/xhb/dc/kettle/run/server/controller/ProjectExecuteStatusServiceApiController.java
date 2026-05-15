package com.xhb.dc.kettle.run.server.controller;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.run.server.api.ProjectExecuteStatusServiceApi;
import com.xhb.dc.kettle.run.server.dto.ProjectHistoryExecuteDTO;
import com.xhb.dc.kettle.run.server.service.ProjectExecutorService;
import com.xhb.dc.kettle.run.server.vo.ProjectHistoryExecuteVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gavin
 * @since 2020/2/13 10:27 上午
 */
@RestController
@RequestMapping("/status")
public class ProjectExecuteStatusServiceApiController implements ProjectExecuteStatusServiceApi {

    private final ProjectExecutorService projectExecutorService;

    @Autowired
    public ProjectExecuteStatusServiceApiController(ProjectExecutorService projectExecutorService) {
        this.projectExecutorService = projectExecutorService;
    }

    @Override
    public Result<List<ProjectHistoryExecuteDTO>, Object> getRunningProject(String userId) {
        final List<ProjectHistoryExecuteDTO> projectHistoryExecute = projectExecutorService.selectRunningProject(userId);
        return Result.success(projectHistoryExecute);
    }

    @Override
    public Result<PageInfo<ProjectHistoryExecuteDTO>, Object> selectUserHistoryExecute(String userId, ProjectHistoryExecuteVO projectHistoryExecuteVO
            , int pageNum, int pageSize) {
        // 设置分页规则
        PageHelper.startPage(pageNum, pageSize);

        PageInfo<ProjectHistoryExecuteDTO> pageInfo = new PageInfo<>(projectExecutorService.selectUserHistoryExecute(userId,projectHistoryExecuteVO));
        return Result.success(pageInfo);
    }
}
