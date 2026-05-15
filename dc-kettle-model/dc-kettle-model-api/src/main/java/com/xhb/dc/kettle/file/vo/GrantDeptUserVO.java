package com.xhb.dc.kettle.file.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 部门用户信息接受类.
 *
 * @author liuhao
 * @since 2022/1/19 16:49
 */

@Data
@ApiModel("部门用户信息接受类")
public class GrantDeptUserVO {

    /**
     * 用户id.
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 用户账号信息.
     */
    @ApiModelProperty("用户账号信息")
    private String account;

    /**
     * 用户名称信息.
     */
    @ApiModelProperty("用户名称信息")
    private String userName;

    /**
     * 文件夹信息.
     */
    @ApiModelProperty("文件夹信息")
    private List<GrantDeptUserFolderVO> grantDeptUserFolderVOList;
}
