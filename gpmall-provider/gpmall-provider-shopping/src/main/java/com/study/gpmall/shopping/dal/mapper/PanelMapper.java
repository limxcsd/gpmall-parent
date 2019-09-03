package com.study.gpmall.shopping.dal.mapper;

import com.study.gpmall.common.tkmapper.TkMapper;
import com.study.gpmall.shopping.dal.entitys.Panel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PanelMapper extends TkMapper<Panel> {

    List<Panel> selectPanelContentById(@Param("panelId") Integer panelId);
}
