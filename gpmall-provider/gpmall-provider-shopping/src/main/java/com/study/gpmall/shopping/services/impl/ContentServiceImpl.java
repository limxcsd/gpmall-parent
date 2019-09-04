package com.study.gpmall.shopping.services.impl;

import com.study.gpmall.common.constants.GlobalConstants;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.shopping.converter.ContentConverter;
import com.study.gpmall.shopping.dal.entitys.PanelContent;
import com.study.gpmall.shopping.dal.mapper.PanelContentMapper;
import com.study.gpmall.shopping.dto.home.NavListResponse;
import com.study.gpmall.shopping.services.IContentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName: ContentServiceImpl
 * @Description: 首页导航
 * @author: limingxing
 * @Date: 2019-08-27 17:36
 */
@Slf4j
@Service
public class ContentServiceImpl implements IContentService {

    @Autowired
    PanelContentMapper panelContentMapper;

    @Autowired
    ContentConverter contentConverter;

    @Override
    public NavListResponse queryNavList() {
        NavListResponse response = new NavListResponse();
        try{
            Example example = new Example(PanelContent.class);
            example.setOrderByClause("sort_order");
            Example.Criteria criteriaContent = example.createCriteria();
            criteriaContent.andEqualTo("panelId", GlobalConstants.HEADER_PANEL_ID);
            List<PanelContent> contentList = panelContentMapper.selectByExample(example);
            //添加缓存操作 TODO
            response.setPannelContentDtos(contentConverter.panelContents2Dto(contentList));
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
        }catch (Exception e){
            log.error("ContentServiceImpl.queryNavList Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
