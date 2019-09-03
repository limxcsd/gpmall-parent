package com.study.gpmall.user.services;

import com.study.gpmall.user.dto.login.KaptchaCodeRequest;
import com.study.gpmall.user.dto.login.KaptchaCodeResponse;

/**
 * @ClassName: IKaptchaService
 * @Description: 验证码Service接口
 * @author: limingxing
 * @Date: 2019-08-24 14:29
 */
public interface IKaptchaService {

    /**
     * 获取图形验证码
     * @param request
     * @return
     */
    KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request);

    /**
     * 验证图形验证码
     * @param request
     * @return
     */
    KaptchaCodeResponse validateKaptchaCode(KaptchaCodeRequest request);
}
