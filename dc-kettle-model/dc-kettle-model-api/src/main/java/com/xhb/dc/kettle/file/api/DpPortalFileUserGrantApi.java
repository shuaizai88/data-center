package com.xhb.dc.kettle.file.api;

import com.github.pagehelper.PageInfo;
import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.file.vo.DpPortalFileUserGrantUptVO;
import com.xhb.dc.kettle.file.vo.DpProtalFileUserGrantBatchAddVO;
import com.xhb.dc.kettle.file.vo.UserGrantQueryVO;
import com.xhb.dc.kettle.file.dto.UserGrantDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 文件授权.
 *
 * @author lizihao
 * @date 2021-12-27 14:53:37
 */
@Api(tags = "文件授权")
public interface DpPortalFileUserGrantApi {

    /**
     * 修改文件管理.
     *
     * @param userId    用户id
     * @param updateVO  文件管理参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改文件管理", notes = "修改文件管理", produces = "application/json")
    Result<String, Object> update(@RequestHeader(value = "authorization-userId") String userId,
                                         @Valid @RequestBody DpPortalFileUserGrantUptVO updateVO);

    /**
     * 根据用户id删除用户授权.
     * @param userId 用户id
     * @return 删除成功
     */
    @DeleteMapping("/deleteByUserId")
    @ApiOperation(value = "根据用户id删除用户授权", notes = "根据用户id删除用户授权", produces = "application/json")
    Result<String, Object> deleteByUserId(@ApiParam("用户id") Integer userId);

    /**
     * 批量新增文件授权.
     *
     * @param userId    用户id
     * @param addVO     新增文件管理参数
     * @return          新增成功
     */
    @ApiOperation(value = "批量新增文件管理", notes = "批量新增文件管理", produces = "application/json")
    @PostMapping("/batchAdd")
    Result<String, Object> batchAdd(@RequestHeader(value = "authorization-userId") String userId,
                               @Valid @RequestBody DpProtalFileUserGrantBatchAddVO addVO);

    /**
     * 查询用户授权列表.
     *
     * @param pageSize 一页查询的数量
     * @param curPage   当前页码
     * @param queryVO 查询参数
     * @return 返回数据
     */
    @ApiOperation(value = "查询用户授权列表", notes = "查询用户授权列表", produces = "application/json")
    @GetMapping("/userGrant/page")
    Result<PageInfo<UserGrantDTO>, Object> queryUserGrant(@ApiParam("页行数") String pageSize, @ApiParam("当前页") String
        curPage, UserGrantQueryVO queryVO);

    /**
     * 根据用户id查询用户授权详细信息.
     * @param userId 用户id
     * @return 返回用户详细信息
     */
    @ApiOperation(value = "根据用户id查询用户授权详细信息", notes = "根据用户id查询用户授权详细信息", produces = "application/json")
    @GetMapping("/userGrantInfo")
    Result<DpPortalFileUserGrantUptVO, Object> queryUserGrantInfo(@ApiParam("用户id") Integer userId);
}
