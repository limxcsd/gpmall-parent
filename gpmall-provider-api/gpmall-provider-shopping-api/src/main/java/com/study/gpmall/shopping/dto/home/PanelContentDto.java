package com.study.gpmall.shopping.dto.home;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: PanelContentDto
 * @Description: 首页导航
 * @author: limingxing
 * @Date: 2019-08-27 12:36
 */
@Data
@ApiModel("首页导航")
public class PanelContentDto implements Serializable {

    private static final long serialVersionUID = -1584205373584476401L;
    private Integer id;

    private Integer panelId;

    private Integer type;

    private Long productId;

    private Integer sortOrder;

    private String fullUrl;

    private String picUrl;

    private String picUrl2;

    private String picUrl3;
}
