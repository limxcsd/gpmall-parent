package com.study.gpmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.common.utils.JwtTokenUtils;
import com.study.gpmall.user.dto.user.*;
import com.study.gpmall.user.services.IReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: AddressController
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-04 10:03
 */
@RestController
@RequestMapping("/shopping")
@Api(tags = "会员收货地址控制层")
public class AddressController {

    @Reference(timeout = 3000)
    IReceiveAddressService addressService;

    @GetMapping("/addresses")
    @ApiOperation("获取当前用户的地址列表")
    public ResponseData addressList(HttpServletRequest request) {
        String userInfo = (String) request.getAttribute(JwtTokenUtils.USER_INFO_KEY);
        JSONObject object = JSON.parseObject(userInfo);
        Long uid = Long.parseLong(object.get("uid").toString());
        AddressListRequest addressListRequest = new AddressListRequest();
        addressListRequest.setMemberId(uid);
        AddressListResponse response = addressService.getAddressList(addressListRequest);
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getList());
        }
        return new ResponseUtils<>().setErrorMsg(response.getMsg());
    }

    @PostMapping("/addresses")
    @ApiOperation("添加用户收货地址")
    public ResponseData addressAdd(HttpServletRequest servletRequest){

        AddAddressRequest request = new AddAddressRequest();
//        String userInfo=(String)servletRequest.getAttribute(JwtTokenUtils.USER_INFO_KEY);
//        JSONObject object= JSON.parseObject(userInfo);
//        Long uid=Long.parseLong(object.get("uid").toString());
//        request.setMemberId(uid);
//        request.setUsername(form.getUserName());
//        request.setStreetName(form.getStreetName());
//        request.setTel(form.getTel());
//        request.setIsDefault(form.is_Default()?1:null);
//        AddAddressResponse response = addressService.createAddress(request);
//
//        if(response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
//            return new ResponseUtils().setData(response.getMsg());
//        }
//        return new ResponseUtils().setErrorMsg(response.getMsg());
        AddAddressResponse response = new AddAddressResponse();
        response.setCode(ResultCodeConstants.SUCCESS.getCode());
        return new ResponseUtils().setData("OK");
    }

    @DeleteMapping("/addresses/{addressid}")
    @ApiOperation("删除用户收货地址")
    public ResponseData deleteAddress(@PathVariable("addressid") Long addressid){
//        DeleteAddressRequest request = new DeleteAddressRequest();
//        request.setAddressId(addressid);
//        DeleteAddressResponse response = addressService.deleteAddress(request);
//
//        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
//            return new ResponseUtil().setData(response.getMsg());
//        }
//        return new ResponseUtil().setErrorMsg(response.getMsg());
        DeleteAddressResponse response = new DeleteAddressResponse();
        response.setCode(ResultCodeConstants.SUCCESS.getCode());
        return new ResponseUtils().setData("OK");
    }

    @PutMapping("/addresses")
    public ResponseData addressUpdate(HttpServletRequest servletRequest){
//        UpdateAddressRequest request = new UpdateAddressRequest();
//        String userInfo=(String)servletRequest.getAttribute(TokenIntercepter.USER_INFO_KEY);
//        JSONObject object= JSON.parseObject(userInfo);
//        Long uid=Long.parseLong(object.get("uid").toString());
//        request.setAddressId(form.getAddressId());
//        request.setIsDefault(form.is_Default()?1:null);
//        request.setStreetName(form.getStreetName());
//        request.setTel(form.getTel());
//        request.setUserId(uid);
//        request.setUserName(form.getUserName());
//
//        UpdateAddressResponse response = addressService.updateAddress(request);
//
//        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
//            return new ResponseUtil().setData(response.getMsg());
//        }
//        return new ResponseUtil().setErrorMsg(response.getMsg());
        UpdateAddressResponse response = new UpdateAddressResponse();
        response.setCode(ResultCodeConstants.SUCCESS.getCode());
        return new ResponseUtils().setData(response);
    }
}
