package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName: AllGoodsCateRequest
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 19:03
 */
@Data
@ApiModel("列举所有商品种类请求参数")
public class AllGoodsCateRequest extends AbstractRequest {

    private String sort;

    @Override
    public void requestCheck() {

    }
}
