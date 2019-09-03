package com.study.gpmall.shopping.dto.cart;

import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: AddCartRequest
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 17:01
 */
@Data
@ApiModel("添加购物车请求参数")
public class AddCartRequest extends AbstractRequest {

    @ApiModelProperty(value = "会员id",required = true)
    private Long memberId;
    @ApiModelProperty(value = "商品id",required = true)
    private Long itemId;
    @ApiModelProperty(value = "购买数量",required = true)
    private Integer num;
    @Override
    public void requestCheck() {

    }
}
