package com.study.gpmall.shopping.services;

import com.study.gpmall.shopping.dto.home.NavListResponse;

/**
 * @ClassName: IContentService
 * @Description: 首页内容展示接口
 * @author: limingxing
 * @Date: 2019-08-27 12:38
 */
public interface IContentService {
    /**
     * 首页导航展示
     * @return
     */
    NavListResponse queryNavList();
}
