package com.study.gpmall.shopping.controller;

import com.study.gpmall.common.result.ResponseData;
import com.study.gpmall.common.result.ResponseUtils;
import com.study.gpmall.shopping.dto.order.OrderListRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: OrderController
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 21:08
 */
@RestController
@RequestMapping("/shopping")
@Api(tags = "用户订单控制层")
public class OrderController {


    /**
     * 获取当前用户的所有订单
     * @return
     */
    @GetMapping("/order")
    public ResponseData orderByCurrentId( HttpServletRequest servletRequest){
        OrderListRequest request = new OrderListRequest();
//        request.setPage(pageInfo.getPage());
//        request.setSize(pageInfo.getSize());
//        request.setSort(pageInfo.getSort());
        /*String userInfo=(String)servletRequest.getAttribute(TokenIntercepter.USER_INFO_KEY);
        JSONObject object= JSON.parseObject(userInfo);
        Long uid=Long.parseLong(object.get("uid").toString());
        request.setUserId(uid);
        OrderListResponse listResponse = orderQueryService.orderList(request);
        if(listResponse.getCode().equals(OrderRetCode.SUCCESS.getCode())){
            PageResponse response = new PageResponse();
            response.setData(listResponse.getDetailInfoList());
            response.setTotal(listResponse.getTotal());
            return new ResponseUtil<>().setData(response);
        }
        return new ResponseUtil<>().setErrorMsg(listResponse.getMsg());*/

        return new ResponseUtils().setData("OK");
    }

}
