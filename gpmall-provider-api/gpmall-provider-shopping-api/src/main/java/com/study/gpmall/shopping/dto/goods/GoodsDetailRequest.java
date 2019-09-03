package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import lombok.Data;

/**
 * @ClassName: ProductDetailRequest
 * @Description: 查看商品明细请求参数
 * @author: limingxing
 * @Date: 2019-08-31 16:38
 */
@Data
public class GoodsDetailRequest extends AbstractRequest {

    private Long id;

    @Override
    public void requestCheck() {
        if(id==null){
            throw new ValidateException(ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
