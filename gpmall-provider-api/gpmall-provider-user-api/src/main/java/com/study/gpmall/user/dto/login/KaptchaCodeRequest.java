package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: KaptchaCodeRequest
 * @Description: 验证码获取请求参数
 * @author: limingxing
 * @Date: 2019-08-24 15:04
 */
@Data
@ApiModel("验证码获取请求参数")
public class KaptchaCodeRequest extends AbstractRequest {

    private String uuid;

    private String code;

    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(uuid)||StringUtils.isBlank(code)){
            throw new ValidateException(
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
