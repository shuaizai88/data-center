package com.xhb.dc.kettle.system.user.vo;

import com.xhb.dc.kettle.core.validation.FieldMatch;
import com.xhb.dc.kettle.system.util.ValidatorConstans;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * UpdatePasswdVo.
 */
@Data
@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "{user.password.fieldMatch}")})
public class UpdatePasswdVo {
    @ApiModelProperty("原密码")
    @NotBlank
    private String oldPassword;

    @ApiModelProperty("密码")
    @NotBlank
    @Pattern(regexp = ValidatorConstans.PWD,
            message = "{user.password.incorrect}")
    private String password;

    @ApiModelProperty("确认密码")
    @NotBlank
    private String confirmPassword;
}
