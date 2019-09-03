package com.study.gpmall.shopping.dal.mapper;

import com.study.gpmall.common.tkmapper.TkMapper;
import com.study.gpmall.shopping.dal.entitys.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper extends TkMapper<Item> {

    List<Item> selectItemFront(@Param("cid") Long cid,
                               @Param("orderCol") String orderCol, @Param("orderDir") String orderDir,
                               @Param("priceGt") Integer priceGt, @Param("priceLte") Integer priceLte);
}
