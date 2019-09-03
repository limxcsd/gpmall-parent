package com.study.gpmall.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.common.utils.JwtTokenUtils;
import com.study.gpmall.user.dto.user.AddressListRequest;
import com.study.gpmall.user.dto.user.AddressListResponse;
import com.study.gpmall.user.services.IReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ReceiveAddressController
 * @Description: 会员收货地址
 * @author: limingxing
 * @Date: 2019-09-02 10:40
 */
@RestController
@RequestMapping("/address")
@Api("会员收货地址")
public class ReceiveAddressController {

    @Reference(timeout = 3000)
    private IReceiveAddressService addressService;

    @GetMapping("/list")
    @ApiOperation("获取当前用户的地址列表")
    public ResponseData list(HttpServletRequest request){
        String userInfo = (String) request.getAttribute(JwtTokenUtils.USER_INFO_KEY);
        JSONObject object = JSON.parseObject(userInfo);
        Long uid = Long.parseLong(object.get("uid").toString());
        AddressListRequest addressListRequest = new AddressListRequest();
        addressListRequest.setMemberId(uid);
        AddressListResponse response = addressService.getAddressList(addressListRequest);
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getList());
        }
        return new ResponseUtils().setErrorMsg(response.getMsg());
    }

}
