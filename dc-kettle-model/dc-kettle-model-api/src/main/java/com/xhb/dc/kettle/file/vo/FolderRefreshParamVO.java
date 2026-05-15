package com.xhb.dc.kettle.file.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class FolderRefreshParamVO {

    @ApiModelProperty("文件夹id集合")
    @NotEmpty(message = "文件夹id集合不能为空")
    private List<String> folderIds;
}
