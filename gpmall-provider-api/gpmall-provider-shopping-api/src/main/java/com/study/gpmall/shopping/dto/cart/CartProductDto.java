package com.study.gpmall.shopping.dto.cart;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: CartProductDto
 * @Description: 购物车商品
 * @author: limingxing
 * @Date: 2019-09-03 17:12
 */
@Data
public class CartProductDto implements Serializable {
    private static final long serialVersionUID = -809047960626248847L;

    private Long productId;

    private BigDecimal salePrice;

    private Long productNum;

    private Long limitNum;

    private String checked;

    private String productName;

    private String productImg;
}
