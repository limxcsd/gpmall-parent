package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.result.AbstractRequest;
import lombok.Data;

/**
 * @ClassName: AllProductRequest
 * @Description: 查询所有商品请求参数
 * @author: limingxing
 * @Date: 2019-08-31 16:46
 */
@Data
public class AllGoodsRequest extends AbstractRequest {

    private Integer page;
    private Integer size;
    private String sort;
    private Long cid;
    private Integer priceGt;
    private Integer priceLte;

    @Override
    public void requestCheck() {
        if (page <= 0) {
            setPage(1);
        }
    }
}
