package com.xhb.dc.kettle.file.api;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.file.vo.DpFileRegularCleanUptVO;
import com.xhb.dc.kettle.file.dto.DpFileRegularCleanDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 文件定时清理API.
 *
 * @author songxiaolang
 * @since 2022-01-04 14:44
 */
@Api(tags = "文件定时清理")
public interface DpFileRegularCleanApi {
    /**
     * 修改定时清理文件设置.
     *
     * @param userId   用户id
     * @param updateVO 文件管理参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改定时清理文件设置", notes = "修改定时清理文件设置", produces = "application/json")
    Result<String, Object> update(@RequestHeader(value = "authorization-userId") String userId,
                                  @Valid @RequestBody DpFileRegularCleanUptVO updateVO);

    /**
     * 查询修定时清理文件设置.
     *
     * @return DpFileRegularCleanDTO
     */
    @GetMapping("/get")
    @ApiOperation(value = "查询定时清理文件设置", notes = "查询修定时清理文件设置", produces = "application/json")
    Result<DpFileRegularCleanDTO, Object> get();

    /**
     * 立即清理.
     *
     * @param effectiveDays 有效天数
     * @param isUseBusiness 是否业务
     * @return String
     */
    @GetMapping("/immediately")
    @ApiOperation(value = "立即清理", notes = "立即清理", produces = "application/json")
    Result<String, Object> immediately(@RequestParam("effectiveDays") Integer effectiveDays, @RequestParam("isUseBusiness") Integer isUseBusiness);

}
