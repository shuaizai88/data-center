package com.xhb.dc.kettle.portal.model.modelgrant.controller;

import com.xhb.dc.kettle.core.util.StatusCode;
import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.portal.model.modelgrant.api.ModelGroupGrantUserServiceApi;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.AddUserGrantGroupListDTO;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.ModelGroupGrantUserDTO;
import com.xhb.dc.kettle.portal.model.modelgrant.vo.AddModelGroupGrantUserVO;
import com.xhb.dc.kettle.portal.model.modelgrant.vo.UpdateModelGroupGrantUserVO;
import com.xhb.dc.kettle.portal.model.modelgrant.service.ModelGroupGrantUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Description : description</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2020/2/12 10:52 PM</li>
 * <li>Author      : ksice_xt</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@RestController
@RequestMapping("/modelGroupGrantUser")
public class ModelGroupGrantUserUserServiceApiController implements ModelGroupGrantUserServiceApi {

    @Autowired
    ModelGroupGrantUserService modelGroupGrantUserService;

    @Override
    public Result add(String userId, AddModelGroupGrantUserVO addModelGroupGrantUserVO) {
        try {
            return modelGroupGrantUserService.insert(userId, addModelGroupGrantUserVO);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(StatusCode.CODE_10010.getCode(), addModelGroupGrantUserVO, "新增失败");
        }
    }

    @Override
    public Result update(String userId, UpdateModelGroupGrantUserVO updateModelGroupGrantUserVO) {
        try {
            return modelGroupGrantUserService.update(userId, updateModelGroupGrantUserVO);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(StatusCode.CODE_10010.getCode(), updateModelGroupGrantUserVO, "更新失败");
        }
    }

    @Override
    public Result selectAll(String userId, String userName, Integer curPage, Integer pageSize, String modelGrantGroupName) {
        PageInfo<ModelGroupGrantUserDTO> pageInfo = modelGroupGrantUserService.selectAll(userId, userName, curPage, pageSize, modelGrantGroupName);
        return Result.success(pageInfo);
    }

    @Override
    public Result delete(String userId, String userGrantId) {
        try {
            return modelGroupGrantUserService.delete(userId, userGrantId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(StatusCode.CODE_10010.getCode(), Boolean.FALSE, "删除失败");
        }
    }

    @Override
    public Result getUserIdAndName(String userId) {

        return Result.success(modelGroupGrantUserService.selectUserIdAndNames(userId));
    }

    @Override
    public Result<List<AddUserGrantGroupListDTO>, Object> getModelGrantGroup(String userId, String modelGroupName) {
        return Result.success(modelGroupGrantUserService.selectGroupModelNameAndModelList(userId, StringUtils.isEmpty(modelGroupName) ? null : modelGroupName));
    }
}
