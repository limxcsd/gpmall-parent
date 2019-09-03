package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: UserRegisterRequest
 * @Description: 会员注册请求参数
 * @author: limingxing
 * @Date: 2019-08-24 10:29
 */
@Data
@ApiModel("会员注册请求参数")
public class UserRegisterRequest extends AbstractRequest {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            throw new ValidateException(
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode(),
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
