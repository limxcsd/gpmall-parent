package com.study.gpmall.shopping.dto.cart;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CartListByIdResponse
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 19:17
 */
@Data
@ApiModel("购物车列表返回参数")
public class CartListByIdResponse extends AbstractResponse {

    private List<CartProductDto> cartProductDtos;
}
