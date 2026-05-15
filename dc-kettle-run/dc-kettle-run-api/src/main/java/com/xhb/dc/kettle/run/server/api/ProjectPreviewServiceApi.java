package com.xhb.dc.kettle.run.server.api;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.run.server.dto.ProjectPreviewExecutorDTO;
import com.xhb.dc.kettle.run.server.vo.ProjectFilePreviewExecutorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author gavin
 * @since 2020/3/5 10:18 上午
 */
@Api(tags = "输入组件数据预览")
public interface ProjectPreviewServiceApi {

    @ApiOperation(value = "预览数据", produces = "application/json")
    @PostMapping(value = "/executePreviewByFile")
    Result<ProjectPreviewExecutorDTO, Object> executeByFile(@RequestBody ProjectFilePreviewExecutorVO previewExecutorVO) throws Exception;

}
