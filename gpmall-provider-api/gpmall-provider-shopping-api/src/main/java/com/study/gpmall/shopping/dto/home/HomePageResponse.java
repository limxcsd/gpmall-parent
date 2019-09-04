package com.study.gpmall.shopping.dto.home;

import com.study.gpmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.Set;

/**
 * @ClassName: HomePageResponse
 * @Description: 主页
 * @author: limingxing
 * @Date: 2019-08-27 20:13
 */
@Data
public class HomePageResponse extends AbstractResponse {

    private Set<PanelDto> panelContentItemDtos;
}
