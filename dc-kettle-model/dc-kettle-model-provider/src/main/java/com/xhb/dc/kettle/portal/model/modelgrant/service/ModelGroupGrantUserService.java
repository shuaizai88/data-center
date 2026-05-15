package com.xhb.dc.kettle.portal.model.modelgrant.service;

import com.xhb.dc.kettle.core.model.Result;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.AddUserGrantGroupListDTO;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.ModelGroupGrantUserDTO;
import com.xhb.dc.kettle.portal.model.modelgrant.dto.UserIdAndNamesDTO;
import com.xhb.dc.kettle.portal.model.modelgrant.vo.AddModelGroupGrantUserVO;
import com.xhb.dc.kettle.portal.model.modelgrant.vo.UpdateModelGroupGrantUserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Description : description</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2020/2/12 11:34 PM</li>
 * <li>Author      : ksice_xt</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
public interface ModelGroupGrantUserService {

    /**
     * 新增用户授权信息
     *
     * @param userId
     * @param addModelGroupGrantUserVO
     * @return
     */
    Result insert(String userId, AddModelGroupGrantUserVO addModelGroupGrantUserVO);


    Result update(String userId, UpdateModelGroupGrantUserVO updateModelGroupGrantUserVO);


    Result delete(String userId, String userName);


    /**
     * 查询用户授权信息
     *
     * @param userId
     * @param userName
     * @param curPage
     * @param pageSize
     * @param modelGrantGroupName
     * @return
     */
    PageInfo<ModelGroupGrantUserDTO> selectAll(String userId, String userName, Integer curPage, Integer pageSize, String modelGrantGroupName);


    /**
     * 获取用户名和id
     *
     * @param userId
     * @return
     */
    List<UserIdAndNamesDTO> selectUserIdAndNames(String userId);

    /**
     * 查询用户授权组和授权组的模型数量
     *
     * @param userId
     * @param groupName
     * @return
     */
    List<AddUserGrantGroupListDTO> selectGroupModelNameAndModelList(String userId, String groupName);
}
