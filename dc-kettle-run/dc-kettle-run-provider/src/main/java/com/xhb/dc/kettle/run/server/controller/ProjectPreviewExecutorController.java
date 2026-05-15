package com.xhb.dc.kettle.run.server.controller;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.run.server.api.ProjectPreviewServiceApi;
import com.xhb.dc.kettle.run.server.dto.ProjectPreviewExecutorDTO;
import com.xhb.dc.kettle.run.server.service.ProjectPreviewExecutorService;
import com.xhb.dc.kettle.run.server.vo.ProjectFilePreviewExecutorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * previewExecutor.
 *
 * @author gavin
 * @since 2020/2/13 10:27 上午
 */
@RestController
@RequestMapping("/previewExecutor")
public class ProjectPreviewExecutorController implements ProjectPreviewServiceApi {

    private final ProjectPreviewExecutorService previewExecutorService;

    @Autowired
    public ProjectPreviewExecutorController(ProjectPreviewExecutorService previewExecutorService) {
        this.previewExecutorService = previewExecutorService;
    }

    @Override
    public Result<ProjectPreviewExecutorDTO, Object> executeByFile(ProjectFilePreviewExecutorVO previewExecutorVO) throws Exception {
        return Result.success(previewExecutorService.executeByFile(previewExecutorVO));
    }
}