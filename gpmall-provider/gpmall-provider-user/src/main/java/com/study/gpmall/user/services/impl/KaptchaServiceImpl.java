package com.study.gpmall.user.services.impl;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.common.result.ImageResult;
import com.study.gpmall.common.utils.VerifyCodeUtils;
import com.study.gpmall.user.dto.login.KaptchaCodeRequest;
import com.study.gpmall.user.dto.login.KaptchaCodeResponse;
import com.study.gpmall.user.services.IKaptchaService;
import com.study.gpmall.user.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @ClassName: KaptchaServiceImpl
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-24 15:33
 */
@Slf4j
@Service
public class KaptchaServiceImpl implements IKaptchaService {

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request) {
        log.error("KaptchaServiceImpl.getKaptchaCode request : {}", request);
        KaptchaCodeResponse response = new KaptchaCodeResponse();
        try {
            ImageResult imageResult = VerifyCodeUtils.verifyCode(140, 43, 4);
            response.setImageCode(imageResult.getImg());
            String uuid = UUID.randomUUID().toString();
            redisUtils.set(VerifyCodeUtils.KAPTCHA_UUID + uuid,imageResult.getCode(), 60);
            response.setUuid(uuid);
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("KaptchaServiceImpl.getKaptchaCode Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public KaptchaCodeResponse validateKaptchaCode(KaptchaCodeRequest request) {
        log.error("KaptchaServiceImpl.validateKaptchaCode request : {}", request);
        KaptchaCodeResponse response = new KaptchaCodeResponse();
        try {
            request.requestCheck();
            String redisKey = VerifyCodeUtils.KAPTCHA_UUID + request.getUuid();
            String code = (String) redisUtils.get(redisKey);
            log.info("请求的redisKey={},请求的code={},从redis获得的code={}", redisKey, request.getCode(), code);
            if (StringUtils.isNotBlank(code) && request.getCode().equalsIgnoreCase(code)) {
                response.setCode(ResultCodeConstants.SUCCESS.getCode());
                response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
                return response;
            }
            response.setCode(ResultCodeConstants.KAPTCHA_CODE_ERROR.getCode());
            response.setMsg(ResultCodeConstants.KAPTCHA_CODE_ERROR.getMessage());
        } catch (Exception e) {
            log.error("KaptchaServiceImpl.validateKaptchaCode Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
