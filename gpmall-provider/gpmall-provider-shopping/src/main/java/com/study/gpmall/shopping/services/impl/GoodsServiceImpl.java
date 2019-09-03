package com.study.gpmall.shopping.services.impl;

import com.alibaba.fastjson.JSON;
import com.study.gpmall.common.constants.GlobalConstants;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.shopping.converter.ContentConverter;
import com.study.gpmall.shopping.converter.ProductCateConverter;
import com.study.gpmall.shopping.dal.entitys.ItemCat;
import com.study.gpmall.shopping.dal.entitys.Panel;
import com.study.gpmall.shopping.dal.entitys.PanelContentItem;
import com.study.gpmall.shopping.dal.mapper.ItemCatMapper;
import com.study.gpmall.shopping.dal.mapper.PanelContentMapper;
import com.study.gpmall.shopping.dal.mapper.PanelMapper;
import com.study.gpmall.shopping.dto.home.PanelDto;
import com.study.gpmall.shopping.dto.goods.*;
import com.study.gpmall.shopping.services.IGoodsService;
import com.study.gpmall.shopping.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: GoodsServiceImpl
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 17:37
 */
@Slf4j
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    PanelMapper panelMapper;
    @Autowired
    PanelContentMapper panelContentMapper;
    @Autowired
    ContentConverter contentConverter;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    ItemCatMapper itemCatMapper;
    @Autowired
    ProductCateConverter productCateConverter;

    @Override
    public GoodsDetailResponse getGoodsDetail(GoodsDetailRequest request) {
        return null;
    }

    @Override
    public AllGoodsResponse getAllProduct(AllGoodsRequest request) {
        return null;
    }

    @Override
    public RecommendResponse getRecommendGoods() {
        RecommendResponse response = new RecommendResponse();
        try {
            String json = (String) redisUtils.get(GlobalConstants.RECOMMEND_PANEL_CACHE_KEY);
            if (StringUtils.isNotBlank(json)) {
                List<PanelDto> panelContentItemDtoList = JSON.parseArray(json, PanelDto.class);
                Set<PanelDto> panelDtoSet = new HashSet<>(panelContentItemDtoList);
                response.setList(panelDtoSet);
                return response;
            }

            List<Panel> panels = panelMapper.selectPanelContentById(GlobalConstants.RECOMMEND_PANEL_ID);
            Set<PanelDto> panelContentItemDtos = new HashSet<PanelDto>();
            panels.parallelStream().forEach(panel -> {
                List<PanelContentItem> panelContentItems = panelContentMapper.selectPanelContentAndProductWithPanelId(panel.getId());
                PanelDto panelDto = contentConverter.panen2Dto(panel);
                panelDto.setPanelContentItems(contentConverter.panelContentItem2Dto(panelContentItems));
                panelContentItemDtos.add(panelDto);
            });
            response.setList(panelContentItemDtos);
            redisUtils.set(GlobalConstants.RECOMMEND_PANEL_CACHE_KEY, JSON.toJSONString(panelContentItemDtos), GlobalConstants.RECOMMEND_CACHE_EXPIRE);
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("GoodsServiceImpl.getRecommendGoods Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AllGoodsCateResponse getAllGoodsCate(AllGoodsCateRequest request) {
        log.error("GoodsServiceImpl.getAllGoodsCate request : {}", request);
        AllGoodsCateResponse response = new AllGoodsCateResponse();
        try {
            String json = (String) redisUtils.get(GlobalConstants.PRODUCT_CATE_CACHE_KEY);
            if (StringUtils.isNotBlank(json)) {
                List<ProductCateDto> productCateDtos = JSON.parseArray(json, ProductCateDto.class);
                response.setList(productCateDtos);
                return response;
            }
            Example itemCatExample = new Example(ItemCat.class);
            String orderCol = "sort_order";
            String orderDir = "asc";
            if(request.getSort().equals("1")){
                orderCol="sort_order";
                orderDir="asc";
            }else if(request.getSort().equals("-1")){
                orderCol="sort_order";
                orderDir="desc";
            }
            itemCatExample.setOrderByClause(orderCol + " " + orderDir);

            List<ItemCat> itemCats = itemCatMapper.selectByExample(itemCatExample);
            List<ProductCateDto> productCateDtoList = productCateConverter.items2Dto(itemCats);
            response.setList(productCateDtoList);

            redisUtils.set( GlobalConstants.PRODUCT_CATE_CACHE_KEY,
                    JSON.toJSON(productCateDtoList).toString(),
                    GlobalConstants.PRODUCT_CATE_EXPIRE_TIME);
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("GoodsServiceImpl.getAllGoodsCate Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

}
