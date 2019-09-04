package com.study.gpmall.shopping.controller;

import com.study.gpmall.common.annotation.Anoymous;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.shopping.dto.goods.AllGoodsCateRequest;
import com.study.gpmall.shopping.dto.goods.AllGoodsCateResponse;
import com.study.gpmall.shopping.dto.goods.RecommendResponse;
import com.study.gpmall.shopping.services.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ProductController
 * @Description: 商品控制层
 * @author: limingxing
 * @Date: 2019-09-03 16:18
 */
@RestController
@RequestMapping("/shopping")
@Api(tags = "商品控制层")
public class GoodsController {

    @Reference(timeout = 3000)
    IGoodsService goodsService;


    @Anoymous
    @GetMapping("/recommend")
    @ApiOperation("查询推荐的商品")
    public ResponseData recommend() {
        RecommendResponse response = goodsService.getRecommendGoods();
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getPanelContentItemDtos());
        }
        return new ResponseUtils().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/categories")
    @ApiOperation("列举所有商品种类")
    @ApiImplicitParam(name = "sort", value = "是否排序", paramType = "query")
    public ResponseData allProductCateList(@RequestParam(value = "sort", required = false, defaultValue = "1") String sort) {
        AllGoodsCateRequest request = new AllGoodsCateRequest();
        request.setSort(sort);
        AllGoodsCateResponse response = goodsService.getAllGoodsCate(request);

        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getProductCateDtoList());
        }
        return new ResponseUtils().setErrorMsg(response.getMsg());
    }
}
