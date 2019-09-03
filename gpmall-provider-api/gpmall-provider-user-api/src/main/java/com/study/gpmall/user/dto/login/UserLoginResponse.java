package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: UserLoginResponse
 * @Description: 会员登录返回参数
 * @author: limingxing
 * @Date: 2019-08-20 20:15
 */
@Data
@ApiModel("会员登录返回参数")
public class UserLoginResponse extends AbstractResponse {
    @ApiModelProperty(value = "用户ID")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "头像")
    private String icon;
    @ApiModelProperty(value = "性别：0->未知；1->男；2->女")
    private Integer gender;
    @ApiModelProperty(value = "积分")
    private Integer integration;
    @ApiModelProperty(value = "token")
    private String token;
}
