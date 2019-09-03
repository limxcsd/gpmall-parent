package com.study.gpmall.user.services.impl;

import com.alibaba.fastjson.JSON;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.utils.JwtTokenUtils;
import com.study.gpmall.user.converter.UserConverterMapper;
import com.study.gpmall.user.dal.entitys.UmsMember;
import com.study.gpmall.user.dal.mapper.UmsMemberMapper;
import com.study.gpmall.user.dto.login.*;
import com.study.gpmall.user.services.IUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserLoginServiceImpl
 * @Description: 用户登录Service接口实现
 * @author: limingxing
 * @Date: 2019-08-23 15:12
 */
@Slf4j
@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private UmsMemberMapper memberMapper;

    @Override
    public UserLoginResponse doLogin(UserLoginRequest request) {
        log.info("Begin UserLoginServiceImpl.doLogin request: {} ", request);
        UserLoginResponse response = new UserLoginResponse();
        try {
            Example example = new Example(UmsMember.class);
            example.createCriteria().andEqualTo("status", 1).andEqualTo("username", request.getUsername());
            List<UmsMember> members = memberMapper.selectByExample(example);
            if (members == null || members.size() == 0) {
                response.setCode(ResultCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(ResultCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }
            if (!DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(members.get(0).getPassword())) {
                response.setCode(ResultCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(ResultCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("uid", members.get(0).getId());
            map.put("icon", members.get(0).getIcon());
            String token = JwtTokenUtils.builder().msg(JSON.toJSON(map).toString()).build().creatJwtToken();
            response = UserConverterMapper.INSTANCE.converter(members.get(0));
            response.setToken(token);
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());

        } catch (Exception e) {
            log.error("UserLoginServiceImpl.doLogin Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        log.info("Begin UserLoginServiceImpl.validToken: request: {}", request);
        CheckAuthResponse response = new CheckAuthResponse();
        try {
            String decodeMsg = JwtTokenUtils.builder().token(request.getToken()).build().freeJwt();
            if (StringUtils.isNotBlank(decodeMsg)) {
                response.setCode(ResultCodeConstants.SUCCESS.getCode());
                response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
                response.setUserinfo(decodeMsg);
                log.info("validate success");
                return response;
            }
            response.setCode(ResultCodeConstants.TOKEN_VALID_FAILED.getCode());
            response.setMsg(ResultCodeConstants.TOKEN_VALID_FAILED.getMessage());
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.validToken Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public UserRegisterResponse doRegister(UserRegisterRequest request) {
        log.info("Begin UserLoginServiceImpl.doRegister: request: {}", request);
        UserRegisterResponse response = new UserRegisterResponse();
        try {
            validUserRegisterRequest(request);
            UmsMember member = new UmsMember();
            member.setStatus(1);
            member.setUsername(request.getUsername());
            member.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
            member.setCreateTime(new Date());
            int result = memberMapper.insert(member);
            if (result != 1) {
                response.setCode(ResultCodeConstants.USER_REGISTER_FAILED.getCode());
                response.setMsg(ResultCodeConstants.USER_REGISTER_FAILED.getMessage());
            }
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.doRegister Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    /**
     * 校验参数以及校验用户名是否存在
     *
     * @param request
     */
    private void validUserRegisterRequest(UserRegisterRequest request) {
        Example example = new Example(UmsMember.class);
        example.createCriteria().andEqualTo("status", 1).andEqualTo("username", request.getUsername());
        List<UmsMember> members = memberMapper.selectByExample(example);
        if (null != members && members.size() > 0) {
            throw new ValidateException(ResultCodeConstants.USERNAME_ALREADY_EXISTS.getCode(), ResultCodeConstants.USERNAME_ALREADY_EXISTS.getMessage());
        }
    }
}
