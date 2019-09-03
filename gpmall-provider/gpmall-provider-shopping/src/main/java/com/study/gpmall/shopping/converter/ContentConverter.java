package com.study.gpmall.shopping.converter;

import com.study.gpmall.shopping.dal.entitys.Panel;
import com.study.gpmall.shopping.dal.entitys.PanelContent;
import com.study.gpmall.shopping.dal.entitys.PanelContentItem;
import com.study.gpmall.shopping.dto.home.PanelContentDto;
import com.study.gpmall.shopping.dto.home.PanelContentItemDto;
import com.study.gpmall.shopping.dto.home.PanelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @ClassName: ContentConverter
 * @Description: 首页导航转换
 * @author: limingxing
 * @Date: 2019-08-27 17:39
 */
@Mapper(componentModel = "spring")
public interface ContentConverter {

    @Mappings({})
    PanelContentDto panelContent2Dto(PanelContent panelContent);

    @Mappings({})
    PanelContentDto panelContentItem2Dto(PanelContentItem panelContentItem);

    @Mappings({})
    PanelDto panen2Dto(Panel panel);

    List<PanelContentDto> panelContents2Dto(List<PanelContent> panelContents);

    List<PanelContentItemDto> panelContentItem2Dto(List<PanelContentItem> panelContentItems);

}
