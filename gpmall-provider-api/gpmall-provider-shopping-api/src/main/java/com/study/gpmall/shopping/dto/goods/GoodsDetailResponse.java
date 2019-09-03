package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName: ProductDetailResponse
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-31 16:40
 */
@Data
@ApiModel("查询商品明细返回数据")
public class GoodsDetailResponse extends AbstractResponse {
    private GoodsDetailDto productDetailDto;
}
