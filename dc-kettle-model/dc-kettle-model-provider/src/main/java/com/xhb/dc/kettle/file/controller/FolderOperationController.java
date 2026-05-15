package com.xhb.dc.kettle.file.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.core.util.PageableHelpUtil;
import com.xhb.dc.kettle.file.api.FolderOperationApi;
import com.xhb.dc.kettle.file.dto.FolderInfoDTO;
import com.xhb.dc.kettle.file.service.DpPortalFileManagerService;
import com.xhb.dc.kettle.file.service.DpPortalFileUserGrantService;
import com.xhb.dc.kettle.file.vo.FileInfoVO;
import com.xhb.dc.kettle.file.vo.FileQueryVO;
import com.xhb.dc.kettle.file.vo.FolderRefreshParamVO;
import com.xhb.dc.kettle.file.vo.GrantDeptVO;
import com.xhb.dc.kettle.file.vo.GrantFolderUserVO;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件模式接口.
 *
 * @author lizihao
 * @date 2021-12-27 14:53:37
 */
@RestController
@RequestMapping("/folder")
public class FolderOperationController implements FolderOperationApi {

    @Resource
    private DpPortalFileManagerService dpPortalFileManagerService;

    @Resource
    private DpPortalFileUserGrantService dpPortalFileUserGrantService;

    @Override
    public Result<List<GrantDeptVO>, Object> queryGranDeptTree(String userId) {
        List<GrantDeptVO> grantDeptVOS = this.dpPortalFileUserGrantService.queryGrantDeptFolder(userId);
        return Result.success(grantDeptVOS);
    }

    @Override
    public Result<List<GrantDeptVO>, Object> queryAdminFolderTree() {
        List<GrantDeptVO> grantDeptVOS = this.dpPortalFileManagerService.queryAdminFolder();
        return Result.success(grantDeptVOS);
    }

    @Override
    public Result<FolderInfoDTO, Object> queryFolderById(String folderId) {
        FolderInfoDTO folderInfoDTO = this.dpPortalFileManagerService.queryOneFolder(folderId);
        return Result.success(folderInfoDTO);
    }

    @Override
    public Result<List<FolderInfoDTO>, Object> queryFolder(String userId) {
        List<FolderInfoDTO> folderInfoDTOS = this.dpPortalFileManagerService.queryFolder(userId);
        return Result.success(folderInfoDTOS);
    }

    @Override
    public Result<PageInfo<FileInfoVO>, Object> queryFile(String userId, FileQueryVO fileQueryVO, ServletRequest servletRequest) {
        fileQueryVO.setMyUserId(userId);
        fileQueryVO.setIsAdmin("0");
        Pageable pageable = PageableHelpUtil.startPage(servletRequest);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), PageableHelpUtil.getOrders(pageable.getSort()));
        PageInfo<FileInfoVO> fileInfoVOPageInfo = this.dpPortalFileManagerService.queryFileByParam(fileQueryVO, pageable);
        return Result.success(fileInfoVOPageInfo);
    }

    @Override
    public Result<PageInfo<FileInfoVO>, Object> queryFileAdmin(ServletRequest servletRequest, FileQueryVO fileQueryVO) {
        fileQueryVO.setIsAdmin("1");
        Pageable pageable = PageableHelpUtil.startPage(servletRequest);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), PageableHelpUtil.getOrders(pageable.getSort()));
        PageInfo<FileInfoVO> fileInfoVOPageInfo = this.dpPortalFileManagerService.queryFileByParam(fileQueryVO, pageable);
        return Result.success(fileInfoVOPageInfo);
    }

    @Override
    public Result<String, Object> refreshOneFolder(String folderId) {
        this.dpPortalFileManagerService.refreshOneFolder(folderId);
        return Result.success("刷新成功！");
    }

    @Override
    public Result<GrantFolderUserVO, Object> queryGrantUserByFolderId(String folderId) {
        GrantFolderUserVO grantUserDTO = this.dpPortalFileUserGrantService.queryGrantUser(folderId);
        return Result.success(grantUserDTO);
    }

    @Override
    public Result<String, Object> refreshFolders(@Valid FolderRefreshParamVO paramVO) {
        List<String> folderIds = paramVO.getFolderIds();
        for (String folderId : folderIds) {
            this.dpPortalFileManagerService.refreshOneFolder(folderId);
        }
        return Result.success("刷新成功！");
    }

}
