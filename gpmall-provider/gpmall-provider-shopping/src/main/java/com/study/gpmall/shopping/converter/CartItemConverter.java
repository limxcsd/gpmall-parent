package com.study.gpmall.shopping.converter;

import com.study.gpmall.shopping.dal.entitys.Item;
import com.study.gpmall.shopping.dto.cart.CartProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * @ClassName: CartItemConverter
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 17:13
 */
@Mapper(componentModel = "spring")
public interface CartItemConverter {

    @Mappings({})
    CartProductDto item2Dto(Item item);
}
