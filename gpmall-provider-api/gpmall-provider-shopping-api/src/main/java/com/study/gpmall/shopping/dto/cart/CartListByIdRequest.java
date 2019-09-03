package com.study.gpmall.shopping.dto.cart;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName: CartListByIdRequest
 * @Description: 购物车列表请求参数
 * @author: limingxing
 * @Date: 2019-09-03 19:15
 */
@Data
@ApiModel("购物车列表请求参数")
public class CartListByIdRequest extends AbstractRequest {
    private Long memberId;

    @Override
    public void requestCheck() {
        if (memberId == null || memberId.intValue() == 0) {
            throw new ValidateException(ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode(), ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
