package com.xhb.dc.kettle.portal.model.modelgrant.controller;

import com.xhb.dc.kettle.core.util.StatusCode;
import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.portal.model.modelgrant.api.ModelGroupServiceApi;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.ModelGrantGroupDTO;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.ModelNameAndGroupNameAndTypes;
import com.xhb.dc.kettle.portal.model.modelgrant.vo.AddModelGroupVO;
import com.xhb.dc.kettle.portal.model.modelgrant.vo.UpdateModelGroupVO;
import com.xhb.dc.kettle.portal.model.modelgrant.service.ModelGroupService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Description : description</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2020/2/12 11:37 PM</li>
 * <li>Author      : ksice_xt</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@RestController
@RequestMapping("/modelGrantGroup")
public class ModeGroupServiceApiController implements ModelGroupServiceApi {

    @Autowired
    ModelGroupService modelGroupService;

    @Override
    public Result add(String userId, AddModelGroupVO addModelGroupVO) {


        if (modelGroupService.insert(userId, addModelGroupVO)) {
            return Result.success(addModelGroupVO);
        } else {
            return Result.fail(StatusCode.CODE_10010.getCode(), addModelGroupVO, "新增授权组失败");
        }
    }

    @Override
    public Result delete(String userId, String modelGrantGroupName) {
        try {
            return Result.success(modelGroupService.delete(userId, modelGrantGroupName));
        } catch (Exception e) {
            return Result.success(false);
        }
    }

    @Override
    public Result update(String userId, UpdateModelGroupVO updateModelGroupVO) {

        try {
            return modelGroupService.update(userId, updateModelGroupVO);
        } catch (Exception e) {
            return Result.success(false);
        }
    }

    @Override
    public Result selectAll(String userId, Integer curPage, Integer pageSize, String modelGrantGroupName) {
        PageInfo<ModelGrantGroupDTO> pageInfo = modelGroupService.selectAll(userId, curPage, pageSize, modelGrantGroupName);
        return Result.success(pageInfo);
    }

    @Override
    public Result<ModelNameAndGroupNameAndTypes, Object> selectAllBusinessModel(String userId, String modelName, String modelGroupName,
                                                                                String modelGroupType, Integer curPage,
                                                                                Integer pageSize) {
        ModelNameAndGroupNameAndTypes modelNameAndGroupNameAndTypes = modelGroupService.selectAllBusinessodel(userId, modelName, modelGroupName, modelGroupType,curPage,pageSize);
        return Result.success(modelNameAndGroupNameAndTypes);
    }

    @Override
    public Result<Boolean, Object> queryModelGroupNameIsExits(String userId, String modelGroupName) {
        Boolean b = modelGroupService.queryModelGroupNameIsExits(userId, modelGroupName);
        return Result.success(b);
    }
}
