package com.study.gpmall.shopping.services.impl;

import com.alibaba.fastjson.JSON;
import com.study.gpmall.common.constants.GlobalConstants;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.shopping.converter.ContentConverter;
import com.study.gpmall.shopping.dal.entitys.Panel;
import com.study.gpmall.shopping.dal.entitys.PanelContentItem;
import com.study.gpmall.shopping.dal.mapper.PanelContentMapper;
import com.study.gpmall.shopping.dal.mapper.PanelMapper;
import com.study.gpmall.shopping.dto.home.HomePageResponse;
import com.study.gpmall.shopping.dto.home.PanelDto;
import com.study.gpmall.shopping.services.IHomePageService;
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
 * @ClassName: HomePageService
 * @Description: 首页
 * @author: limingxing
 * @Date: 2019-08-27 20:15
 */
@Slf4j
@Service
public class HomePageServiceImpl implements IHomePageService {


    @Autowired
    PanelMapper panelMapper;
    @Autowired
    ContentConverter contentConverter;
    @Autowired
    PanelContentMapper panelContentMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public HomePageResponse homepage() {
        log.info("Begin HomePageServiceImpl.homepage");
        HomePageResponse response = new HomePageResponse();
        response.setCode(ResultCodeConstants.SUCCESS.getCode());
        response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
        try {
            String json = (String) redisUtils.get(GlobalConstants.HOMEPAGE_CACHE_KEY);
            if (StringUtils.isNoneEmpty(json)) {
                List<PanelDto> panelDtoList = JSON.parseArray(json, PanelDto.class);
                Set set = new HashSet(panelDtoList);
                response.setPanelContentItemDtos(set);
                return response;
            }
            Example example = new Example(Panel.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("position", 0);
            criteria.andEqualTo("status", 1);
            example.setOrderByClause("sort_order");
            List<Panel> panels = panelMapper.selectByExample(example);
            Set<PanelDto> panelContentItemDtos = new HashSet<PanelDto>();
            panels.parallelStream().forEach(panel -> {
                List<PanelContentItem> panelContentItems = panelContentMapper.selectPanelContentAndProductWithPanelId(panel.getId());
                PanelDto panelDto = contentConverter.panen2Dto(panel);
                panelDto.setPanelContentItems(contentConverter.panelContentItem2Dto(panelContentItems));
                panelContentItemDtos.add(panelDto);
            });
            redisUtils.set(GlobalConstants.HOMEPAGE_CACHE_KEY, JSON.toJSONString(panelContentItemDtos), GlobalConstants.HOMEPAGE_EXPIRE_TIME);
            response.setPanelContentItemDtos(panelContentItemDtos);
        } catch (Exception e) {
            log.error("HomePageServiceImpl.homepage Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
