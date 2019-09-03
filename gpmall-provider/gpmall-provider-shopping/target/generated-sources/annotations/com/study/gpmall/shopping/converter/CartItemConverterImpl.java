package com.study.gpmall.shopping.converter;

import com.study.gpmall.shopping.dal.entitys.Item;
import com.study.gpmall.shopping.dto.cart.CartProductDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-03T18:56:08+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class CartItemConverterImpl implements CartItemConverter {

    @Override
    public CartProductDto item2Dto(Item item) {
        if ( item == null ) {
            return null;
        }

        CartProductDto cartProductDto = new CartProductDto();

        if ( item.getLimitNum() != null ) {
            cartProductDto.setLimitNum( item.getLimitNum().longValue() );
        }

        return cartProductDto;
    }
}
