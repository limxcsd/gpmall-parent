package com.study.gpmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.common.utils.JwtTokenUtils;
import com.study.gpmall.shopping.dto.cart.AddCartRequest;
import com.study.gpmall.shopping.dto.cart.AddCartResponse;
import com.study.gpmall.shopping.dto.cart.CartListByIdRequest;
import com.study.gpmall.shopping.dto.cart.CartListByIdResponse;
import com.study.gpmall.shopping.services.ICartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: CartController
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 17:21
 */
@RestController
@RequestMapping("/shopping")
@Api(tags = "购物车控制层")
public class CartController {
    @Reference(timeout = 5000)
    ICartService cartService;


    @PostMapping("/carts")
    @ApiOperation("添加商品到购物车")
    @ApiImplicitParam(name = "AddCartRequest", value = "购物车信息", dataType = "AddCartRequest", required = true)
    public ResponseData addCart(@RequestBody AddCartRequest request) {
        AddCartResponse response = cartService.addCart(request);
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getMsg());
        }
        return new ResponseUtils<>().setErrorMsg(response.getMsg());
    }

    @GetMapping("/carts")
    @ApiOperation("获得购物车列表")
    public ResponseData carts(HttpServletRequest request) {
        String userInfo = (String) request.getAttribute(JwtTokenUtils.USER_INFO_KEY);
        JSONObject jsonObject = JSON.parseObject(userInfo);
        long uid = Long.parseLong(jsonObject.getString("uid"));
        CartListByIdRequest cartListByIdRequest = new CartListByIdRequest();
        cartListByIdRequest.setMemberId(uid);
        CartListByIdResponse response = cartService.getCartListById(cartListByIdRequest);
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getCartProductDtos());
        }
        return new ResponseUtils().setErrorMsg(response.getMsg());
    }


}
