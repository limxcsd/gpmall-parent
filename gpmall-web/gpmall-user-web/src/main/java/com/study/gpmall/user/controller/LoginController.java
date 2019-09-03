package com.study.gpmall.user.controller;

import com.alibaba.fastjson.JSON;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.common.utils.CookieUtils;
import com.study.gpmall.common.utils.JwtTokenUtils;
import com.study.gpmall.common.utils.VerifyCodeUtils;
import com.study.gpmall.user.dto.login.*;
import com.study.gpmall.user.services.IKaptchaService;
import com.study.gpmall.user.services.IUserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-23 19:51
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户登录接口")
public class LoginController {

    @Reference(timeout = 3000)
    private IUserLoginService userLoginService;
    @Reference
    private IKaptchaService kaptchaService;
    /**
     * 验证码开关
     */
    @Value("${captchaFlag:true}")
    private boolean captchaFlag;


    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseData doLogin(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setPassword(map.get("userPwd"));
        loginRequest.setUsername(map.get("userName"));
        String captcha = map.get("captcha");
        if (captchaFlag) {
            KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
            String uuid = CookieUtils.getCookieValue(request, VerifyCodeUtils.KAPTCHA_UUID);
            kaptchaCodeRequest.setCode(captcha);
            kaptchaCodeRequest.setUuid(uuid);
            KaptchaCodeResponse kaptchaCodeResponse = kaptchaService.validateKaptchaCode(kaptchaCodeRequest);
            if (!kaptchaCodeResponse.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
                return new ResponseUtils<>().setErrorMsg(kaptchaCodeResponse.getMsg());
            }
        }

        UserLoginResponse loginResponse = userLoginService.doLogin(loginRequest);
        if (loginResponse.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            Cookie cookie = CookieUtils.genCookie(JwtTokenUtils.ACCESS_TOKEN, loginResponse.getToken(), "/", 24 * 60 * 60);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return new ResponseUtils().setData(loginResponse);
        }
        return new ResponseUtils().setErrorMsg(loginResponse.getMsg());
    }

    @ApiOperation(value = "校验登录")
    @GetMapping("/login")
    public ResponseData checkLogin(HttpServletRequest request) {
        String userInfo = (String) request.getAttribute(JwtTokenUtils.USER_INFO_KEY);
        Object object = JSON.parse(userInfo);
        return new ResponseUtils().setData(object);
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("/loginOut")
    public ResponseData loginOut(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(JwtTokenUtils.ACCESS_TOKEN)) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    response.addCookie(cookie); //覆盖原来的token
                }
            }
        }
        return new ResponseUtils().setData(null);
    }

    @PostMapping("/register")
    @ApiOperation("会员用户注册")
    public ResponseData doRegister(@RequestBody Map<String, String> map, HttpServletRequest request) {
        UserRegisterRequest loginRequest = new UserRegisterRequest();
        loginRequest.setPassword(map.get("userPwd"));
        loginRequest.setUsername(map.get("userName"));
        UserRegisterResponse response = userLoginService.doRegister(loginRequest);
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData("SUCCESS");
        }
        return new ResponseUtils().setData(response.getMsg());
    }
}
