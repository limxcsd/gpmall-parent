package com.study.gpmall.shopping.controller;

import com.study.gpmall.common.annotation.Anoymous;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.shopping.dto.home.HomePageResponse;
import com.study.gpmall.shopping.dto.home.NavListResponse;
import com.study.gpmall.shopping.services.IContentService;
import com.study.gpmall.shopping.services.IHomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HomeController
 * @Description:
 * @author: Adminstrator
 * @Date: 2019-08-25 09:13
 */
@RestController
@RequestMapping("/shopping")
@Api(tags = "导航控制层")
public class HomeController {

    @Reference(timeout = 3000)
    IContentService contentService;

    @Reference(timeout = 3000)
    IHomePageService homePageService;


    @GetMapping("/navigation")
    @ApiOperation("导航")
    public ResponseData navigation() {
        NavListResponse response = contentService.queryNavList();
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getPannelContentDtos());
        }
        return new ResponseUtils<>().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/homepage")
    @ApiOperation("主页")
    public ResponseData homepage() {
        HomePageResponse response = homePageService.homepage();
        if (response.getCode().equals(ResultCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtils().setData(response.getPanelContentItemDtos());
        }
        return new ResponseUtils().setErrorMsg(response.getMsg());
    }

}
