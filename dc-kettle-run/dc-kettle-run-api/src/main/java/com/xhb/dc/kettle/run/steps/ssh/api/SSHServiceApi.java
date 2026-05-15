package com.xhb.dc.kettle.run.steps.ssh.api;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.run.steps.ssh.vo.SSHVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Api(tags = "SSH_API接口")
public interface SSHServiceApi {

    @ApiOperation(value = "测试链接", produces = "application/json")
    @PostMapping(value = "/testSSHConnect")
    Result testSSHConnect(@RequestBody SSHVO sshvo);

    @ApiOperation(value = "pem文件上传", produces = "application/json")
    @PostMapping("/upload")
    Result  upload(@RequestParam("file") MultipartFile file) ;
}
