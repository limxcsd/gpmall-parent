package com.study.gpmall.user.controller;

import com.study.gpmall.common.annotation.Anoymous;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.common.utils.CookieUtils;
import com.study.gpmall.common.utils.VerifyCodeUtils;
import com.study.gpmall.user.dto.login.KaptchaCodeRequest;
import com.study.gpmall.user.dto.login.KaptchaCodeResponse;
import com.study.gpmall.user.services.IKaptchaService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: CaptchaController
 * @Description: 验证码
 * @author: limingxing
 * @Date: 2019-08-24 17:53
 */
@RestController
@RequestMapping("/user")
public class CaptchaController {

    @Reference
    private IKaptchaService kaptchaService;

    @Anoymous
    @GetMapping("/kaptcha")
    @ApiOperation(value = "获取验证码")
    public ResponseData getKaptchaCode(HttpServletResponse response) {
        KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
        KaptchaCodeResponse kaptchaCodeResponse = kaptchaService.getKaptchaCode(kaptchaCodeRequest);
        if (kaptchaCodeResponse.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            Cookie cookie = CookieUtils.genCookie(VerifyCodeUtils.KAPTCHA_UUID, kaptchaCodeResponse.getUuid(), "/", 60);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return new ResponseUtils<>().setData(kaptchaCodeResponse.getImageCode());
        }
        return new ResponseUtils<>().setErrorMsg(kaptchaCodeResponse.getCode());
    }

    @Anoymous
    @PostMapping("/kaptcha")
    @ApiOperation(value = "校验验证码")
    public ResponseData validKaptchaCode(@RequestBody String code, HttpServletRequest httpServletRequest) {
        KaptchaCodeRequest request = new KaptchaCodeRequest();
        String uuid = CookieUtils.getCookieValue(httpServletRequest, "kaptcha_uuid");
        request.setUuid(uuid);
        request.setCode(code);
        KaptchaCodeResponse response = kaptchaService.validateKaptchaCode(request);
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils<>().setData(null);
        }
        return new ResponseUtils<>().setErrorMsg(response.getCode());
    }
}
