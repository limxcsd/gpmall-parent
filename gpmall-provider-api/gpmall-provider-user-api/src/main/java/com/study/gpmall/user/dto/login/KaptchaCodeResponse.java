package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName: KaptchaCodeResponse
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-24 15:06
 */
@Data
@ApiModel("验证码获取返回")
public class KaptchaCodeResponse extends AbstractResponse {

    private String imageCode;

    private String uuid;

}
