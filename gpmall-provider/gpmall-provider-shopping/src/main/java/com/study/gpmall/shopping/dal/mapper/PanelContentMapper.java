package com.study.gpmall.shopping.dal.mapper;

import com.study.gpmall.common.tkmapper.TkMapper;
import com.study.gpmall.shopping.dal.entitys.PanelContent;
import com.study.gpmall.shopping.dal.entitys.PanelContentItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PanelContentMapper extends TkMapper<PanelContent> {

    List<PanelContentItem> selectPanelContentAndProductWithPanelId(@Param("panelId") Integer panelId);
}
