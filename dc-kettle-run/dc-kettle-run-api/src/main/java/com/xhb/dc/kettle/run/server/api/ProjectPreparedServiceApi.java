package com.xhb.dc.kettle.run.server.api;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.run.server.dto.ProjectPreviewExecutorDTO;
import com.xhb.dc.kettle.run.server.vo.ProjectFilePreviewExecutorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author gavin
 * @since 2020/3/5 10:18 上午
 */
@Api(tags = "步骤预执行数据预览")
public interface ProjectPreparedServiceApi {

    @ApiOperation(value = "预览数据", produces = "application/json")
    @PostMapping(value = "/executeByFile")
    Result<ProjectPreviewExecutorDTO, Object> executeByFile(@RequestHeader("authorization-userId") String userId
            , @RequestBody ProjectFilePreviewExecutorVO previewExecutorVO) throws Exception;

}
