package com.study.gpmall.shopping.dto.home;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PanelDto
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-27 12:36
 */
@Data
public class PanelDto implements Serializable {
    private static final long serialVersionUID = -9099372701554072936L;
    private Integer id;

    private String name;

    private Integer type;

    private Integer sortOrder;

    private Integer position;

    private Integer limitNum;

    private Integer status;

    private String remark;

    private List<PanelContentItemDto> panelContentItems;
}
