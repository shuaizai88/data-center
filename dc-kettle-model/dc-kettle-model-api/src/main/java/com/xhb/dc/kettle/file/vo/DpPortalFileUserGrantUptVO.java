package com.xhb.dc.kettle.file.vo;

import com.xhb.dc.kettle.file.dto.FileGrantDTO;
import com.xhb.dc.kettle.file.dto.FolderGrantDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 文件管理表.
 * @author lizihao
 * @date 2021-12-27 14:53:37
 */
@ApiModel
@Data
public class DpPortalFileUserGrantUptVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("需要授权的用户id")
    private List<Integer> userIdList;

    @ApiModelProperty("文件夹集合")
    private List<FolderGrantDTO> folderGrantDTOS;

    @ApiModelProperty("文件集合")
    private List<FileGrantDTO> fileGrantDTOS;
}
