package com.xhb.dc.kettle.file.controller;

import com.github.pagehelper.Page;
import com.xhb.dc.kettle.file.api.DpPortalFileUserGrantApi;
import com.xhb.dc.kettle.file.service.DpPortalFileUserGrantService;
import com.xhb.dc.kettle.file.utils.PageInfoUtil;
import com.xhb.dc.kettle.file.vo.DpPortalFileUserGrantUptVO;
import com.xhb.dc.kettle.file.vo.DpProtalFileUserGrantBatchAddVO;
import com.xhb.dc.kettle.file.vo.UserGrantQueryVO;
import com.xhb.dc.kettle.file.dto.UserGrantDTO;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.xhb.dc.kettle.core.model.Result;
import com.github.pagehelper.PageInfo;

/**
 * 文件授权.
 *
 * @author lizihao
 * @date 2021-12-27 14:53:37
 */
@Api(tags = "文件授权")
@RestController
@RequestMapping("/dpPortalFileUserGrant")
public class DpPortalFileUserGrantController implements DpPortalFileUserGrantApi {

    @Resource
    private DpPortalFileUserGrantService dpPortalFileUserGrantService;

    @Override
    public Result<String, Object> update(String userId, DpPortalFileUserGrantUptVO updateVO) {

        this.dpPortalFileUserGrantService.update(userId, updateVO);
        return Result.success("修改文件管理成功");
    }

    @Override
    public Result<String, Object> deleteByUserId(Integer userId) {
        this.dpPortalFileUserGrantService.deleteByUserId(userId);
        return Result.success("删除成功");
    }

    @Override
    public Result<String, Object> batchAdd(String userId, @Valid DpProtalFileUserGrantBatchAddVO addVO) {
        this.dpPortalFileUserGrantService.batchInsert(addVO, userId);
        return Result.success("删除成功");
    }

    @Override
    public Result<PageInfo<UserGrantDTO>, Object> queryUserGrant(String pageSize, String
        curPage, UserGrantQueryVO queryVO) {
        Page page = PageInfoUtil.initPage(pageSize, curPage);
        PageInfo<UserGrantDTO> userGrantDTOPageInfo = this.dpPortalFileUserGrantService.queryUserGrant(queryVO, page);
        return Result.success(userGrantDTOPageInfo);
    }

    @Override
    public Result<DpPortalFileUserGrantUptVO, Object> queryUserGrantInfo(Integer userId) {
        DpPortalFileUserGrantUptVO userGrant = this.dpPortalFileUserGrantService.getUserGrant(userId);
        return Result.success(userGrant);
    }

}
