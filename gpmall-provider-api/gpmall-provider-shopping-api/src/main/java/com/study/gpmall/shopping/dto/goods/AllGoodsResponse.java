package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: AllProductResponse
 * @Description: 查询所有商品返回数据
 * @author: limingxing
 * @Date: 2019-08-31 16:47
 */
@Data
public class AllGoodsResponse extends AbstractResponse {

    private List<ProductDto> productDtoList;

    private Long total;
}
