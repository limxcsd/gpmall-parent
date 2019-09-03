package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: UserLoginRequest
 * @Description: 登录用户请求
 * @author: limingxing
 * @Date: 2019-08-20 14:51
 */
@Data
@ApiModel("会员登录请求参数")
public class UserLoginRequest extends AbstractRequest {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("登录密码")
    private String password;


    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            throw new ValidateException(
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
