package com.study.gpmall.shopping.dto.goods;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ProductCateDto
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 19:05
 */
@Data
public class ProductCateDto implements Serializable {
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private String iconUrl;
}
