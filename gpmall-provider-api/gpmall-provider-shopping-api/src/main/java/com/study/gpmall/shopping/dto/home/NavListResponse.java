package com.study.gpmall.shopping.dto.home;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: NavListResponse
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-27 12:36
 */
@Data
@ApiModel("首页导航返回参数")
public class NavListResponse extends AbstractResponse {

    private List<PanelContentDto> pannelContentDtos;
}
