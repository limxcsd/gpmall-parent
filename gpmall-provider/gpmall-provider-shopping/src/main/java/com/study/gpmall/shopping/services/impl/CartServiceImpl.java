package com.study.gpmall.shopping.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.gpmall.common.constants.GlobalConstants;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.shopping.converter.CartItemConverter;
import com.study.gpmall.shopping.dal.entitys.Item;
import com.study.gpmall.shopping.dal.mapper.ItemMapper;
import com.study.gpmall.shopping.dto.cart.*;
import com.study.gpmall.shopping.services.ICartService;
import com.study.gpmall.shopping.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CartServiceImpl
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 17:06
 */
@Slf4j
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    CartItemConverter cartItemConverter;

    @Override
    public AddCartResponse addCart(AddCartRequest request) {
        log.error("Begin CartServiceImpl.addCart request : {}", request);
        AddCartResponse response = new AddCartResponse();
        try {
            Item item = itemMapper.selectByPrimaryKey(request.getItemId().longValue());
            if (null != item) {
                CartProductDto cartProductDto = cartItemConverter.item2Dto(item);
                cartProductDto.setChecked("true");
                cartProductDto.setProductNum(request.getNum().longValue());
                redisUtils.set(generatorCartItemKey(request.getMemberId()), JSON.toJSON(cartProductDto).toString());
                return response;
            }
            response.setCode(ResultCodeConstants.SYSTEM_ERROR.getCode());
            response.setMsg(ResultCodeConstants.SYSTEM_ERROR.getMessage());
        } catch (Exception e) {
            log.error("CartServiceImpl.addCart Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public CartListByIdResponse getCartListById(CartListByIdRequest request) {
        log.error("Begin CartServiceImpl.getCartListById request : {}", request);
        CartListByIdResponse response = new CartListByIdResponse();
        try {
            List<CartProductDto> productDtos = new ArrayList<>();
            Map<Object, Object> items = redisUtils.hmget(generatorCartItemKey(request.getMemberId()));
            items.values().forEach(obj -> {
                CartProductDto cartProductDto = JSONObject.parseObject(obj.toString(), CartProductDto.class);
                productDtos.add(cartProductDto);
            });
            response.setCartProductDtos(productDtos);
        } catch (Exception e) {
            log.error("CartServiceImpl.getCartListById Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    private String generatorCartItemKey(long memberId) {
        StringBuilder sb = new StringBuilder(GlobalConstants.CART_ITEM_CACHE_PREFIX);
        sb.append(":").append(memberId);
        return sb.toString();
    }

}
