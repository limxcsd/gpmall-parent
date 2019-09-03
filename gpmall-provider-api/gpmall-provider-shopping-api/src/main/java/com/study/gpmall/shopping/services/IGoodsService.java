package com.study.gpmall.shopping.services;

import com.study.gpmall.shopping.dto.goods.*;

/**
 * @ClassName: IGoodsService
 * @Description: 品信息服务接口
 * @author: limingxing
 * @Date: 2019-09-03 17:33
 */
public interface IGoodsService {

    /**
     * 查看商品明细
     * @param request
     * @return
     */
    GoodsDetailResponse getGoodsDetail(GoodsDetailRequest request);
    /**
     * 查询所有商品（分页）
     * @param request
     * @return
     */
    AllGoodsResponse getAllProduct(AllGoodsRequest request);

    /**
     * 获取推荐的商品板块
     * @return
     */
    RecommendResponse getRecommendGoods();

    /**
     *  列举所有商品种类
     * @param request
     * @return
     */
    AllGoodsCateResponse getAllGoodsCate(AllGoodsCateRequest request);
}
