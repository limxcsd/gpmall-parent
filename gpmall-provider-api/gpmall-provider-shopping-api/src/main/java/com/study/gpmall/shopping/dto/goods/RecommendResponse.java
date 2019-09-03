package com.study.gpmall.shopping.dto.goods;

import com.study.gpmall.common.result.AbstractResponse;
import com.study.gpmall.shopping.dto.home.PanelDto;
import lombok.Data;

import java.util.Set;

/**
 * @ClassName: RecommendResponse
 * @Description: 推荐的商品返回数据
 * @author: limingxing
 * @Date: 2019-08-31 16:50
 */
@Data
public class RecommendResponse extends AbstractResponse {
    private Set<PanelDto> list;
}
