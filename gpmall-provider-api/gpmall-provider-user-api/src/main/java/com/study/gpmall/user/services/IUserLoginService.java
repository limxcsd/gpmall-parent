package com.study.gpmall.user.services;

import com.study.gpmall.user.dto.login.*;

/**
 * @ClassName: IUserLoginService
 * @Description: 会员用户登录Service
 * @author: limingxing
 * @Date: 2019-08-23 14:52
 */
public interface IUserLoginService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    UserLoginResponse doLogin(UserLoginRequest request);


    /**
     * 校验过程
     * @param request
     * @return
     */
    CheckAuthResponse validToken(CheckAuthRequest request);

    /**
     * 会员注册
     * @param request
     * @return
     */
    UserRegisterResponse doRegister(UserRegisterRequest request);
}
