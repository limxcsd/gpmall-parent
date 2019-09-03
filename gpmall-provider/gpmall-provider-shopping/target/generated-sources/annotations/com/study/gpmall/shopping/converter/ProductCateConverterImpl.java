package com.study.gpmall.shopping.converter;

import com.study.gpmall.shopping.dal.entitys.ItemCat;
import com.study.gpmall.shopping.dto.goods.ProductCateDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-03T19:24:55+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class ProductCateConverterImpl implements ProductCateConverter {

    @Override
    public ProductCateDto item2Dto(ItemCat itemCat) {
        if ( itemCat == null ) {
            return null;
        }

        ProductCateDto productCateDto = new ProductCateDto();

        productCateDto.setName( itemCat.getName() );
        productCateDto.setIsParent( itemCat.getIsParent() );
        productCateDto.setId( itemCat.getId() );
        productCateDto.setIconUrl( itemCat.getIcon() );
        productCateDto.setParentId( itemCat.getParentId() );

        return productCateDto;
    }

    @Override
    public List<ProductCateDto> items2Dto(List<ItemCat> items) {
        if ( items == null ) {
            return null;
        }

        List<ProductCateDto> list = new ArrayList<ProductCateDto>( items.size() );
        for ( ItemCat itemCat : items ) {
            list.add( item2Dto( itemCat ) );
        }

        return list;
    }
}
