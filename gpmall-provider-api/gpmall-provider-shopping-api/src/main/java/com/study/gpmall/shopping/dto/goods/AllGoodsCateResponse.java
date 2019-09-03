package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: AllGoodsCateResponse
 * @Description: 列举所有商品种类返回参数
 * @author: limingxing
 * @Date: 2019-09-03 19:04
 */
@Data
public class AllGoodsCateResponse extends AbstractResponse {

    private List<ProductCateDto> list;
}
