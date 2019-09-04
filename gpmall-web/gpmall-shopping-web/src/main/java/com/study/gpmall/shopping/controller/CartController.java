package com.study.gpmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.common.utils.JwtTokenUtils;
import com.study.gpmall.shopping.dto.cart.*;
import com.study.gpmall.shopping.services.ICartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.tomcat.util.http.ResponseUtil;
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
        if (null == userInfo) {
            return new ResponseUtils().setErrorMsg("该用户登录无效");
        }
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

    @PutMapping("/carts")
    @ApiOperation("更新购物车中的商品")
    public ResponseData updateCarts() {//    @RequestBody UpdateCartNumRequest cartForm
//        UpdateCartNumRequest request=new UpdateCartNumRequest();
//        request.setChecked(cartForm.getChecked());
//        request.setItemId(cartForm.getProductId());
//        request.setNum(cartForm.getProductNum());
//        request.setUserId(cartForm.getUserId());
//        UpdateCartNumResponse response=iCartService.updateCartNum(request);
//        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
//            return new ResponseUtil().setData(response.getMsg());
//        }
//        return new ResponseUtil().setErrorMsg(response.getMsg());
        return new ResponseUtils().setData("OK");
    }


    @DeleteMapping("/carts/{uid}/{pid}")
    @ApiOperation("删除购物车中的商品")
    public ResponseData deleteCarts(@PathVariable("uid") long uid, @PathVariable("pid") long pid) {
//        DeleteCartItemRequest request=new DeleteCartItemRequest();
//        request.setUserId(uid);
//        request.setItemId(pid);
//        DeleteCartItemResponse response=iCartService.deleteCartItem(request);
//        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
//            return new ResponseUtils().setData(response.getMsg());
//        }
//        return new ResponseUtils().setErrorMsg(response.getMsg());
        DeleteCartItemResponse response = new DeleteCartItemResponse();
        response.setCode(ResultCodeConstants.SUCCESS.getCode());
        return new ResponseUtils().setData(response);
    }


    @PutMapping("/items")
    @ApiOperation("对购物车的全选操作")
    public ResponseData checkCarts() {   //@RequestBody CartForm cartForm
//        CheckAllItemRequest request=new CheckAllItemRequest();
//        request.setChecked(cartForm.getChecked());
//        request.setUserId(cartForm.getUserId());
//        CheckAllItemResponse response=iCartService.checkAllCartItem(request);
//        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
//            return new ResponseUtil().setData(response.getMsg());
//        }
//        return new ResponseUtil().setErrorMsg(response.getMsg());
        CheckAllItemResponse response = new CheckAllItemResponse();
        response.setMsg("OK");
        return new ResponseUtils().setData(response.getMsg());
    }

    @DeleteMapping("/items/{id}")
    @ApiOperation("删除购物车中选中的商品")
    public ResponseData deleteCheckCartItem(@PathVariable("id") Long id) {
//        DeleteCheckedItemRequest request = new DeleteCheckedItemRequest();
//        request.setUserId(id);
//        request.setUserId(request.getUserId());
//        DeleteCheckedItemResposne response = iCartService.deleteCheckedItem(request);
//        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
//            return new ResponseUtil().setData(response.getMsg());
//        }
//        return new ResponseUtil().setErrorMsg(response.getMsg());
        DeleteCheckedItemResposne response = new DeleteCheckedItemResposne();
        response.setMsg("OK");
        return new ResponseUtils().setData(response.getMsg());
    }

}
