package com.study.gpmall.shopping.services;

import com.study.gpmall.shopping.dto.home.HomePageResponse;

/**
 * @ClassName: IHomeService
 * @Description: 首页
 * @author: limingxing
 * @Date: 2019-08-27 20:14
 */
public interface IHomePageService {
    /**
     * 首页展示
     * @return
     */
    HomePageResponse homepage();
}
