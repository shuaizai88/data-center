package com.xhb.dc.kettle.file.vo;

import com.xhb.dc.kettle.file.dto.GrantUserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 授权文件夹信息接受类.
 */

@Data
@ApiModel("授权文件夹信息接受类")
public class GrantFolderUserVO {

    /**
     * 所有用户.
     */
    @ApiModelProperty("所有用户")
    private List<GrantUserDTO> allUser;

    /**
     * 已授权的用户.
     */
    @ApiModelProperty("已授权的用户")
    private List<GrantUserDTO> grantUser;
}
