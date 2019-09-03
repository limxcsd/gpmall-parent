package com.study.gpmall.shopping.services;

import com.study.gpmall.shopping.dto.cart.AddCartRequest;
import com.study.gpmall.shopping.dto.cart.AddCartResponse;
import com.study.gpmall.shopping.dto.cart.CartListByIdRequest;
import com.study.gpmall.shopping.dto.cart.CartListByIdResponse;

/**
 * @ClassName: ICartService
 * @Description: 购物车信息，统一采用缓存存储
 * @author: limingxing
 * @Date: 2019-09-03 17:00
 */
public interface ICartService {

    /**
     * 添加购物车
     * @param request
     * @return
     */
    AddCartResponse addCart(AddCartRequest request);

    /**
     * 查询购物车列表
     * @param request
     * @return
     */
    CartListByIdResponse getCartListById(CartListByIdRequest request);
}
