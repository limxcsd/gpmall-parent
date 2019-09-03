package com.study.gpmall.user.converter;

import com.study.gpmall.user.dal.entitys.UmsReceiveAddress;
import com.study.gpmall.user.dto.user.AddAddressRequest;
import com.study.gpmall.user.dto.user.UmsAddressDto;
import com.study.gpmall.user.dto.user.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @ClassName: MemberAddressConverter
 * @Description: 会员收货地址转换
 * @author: Adminstrator
 * @Date: 2019-08-25 20:04
 */
@Mapper(componentModel = "spring")
public interface ReceiveAddressConverter {

    @Mappings({})
    UmsAddressDto address2List(UmsReceiveAddress address);

    List<UmsAddressDto> address2List(List<UmsReceiveAddress> addresses);

    @Mappings({})
    UmsReceiveAddress req2Address(AddAddressRequest request);

    @Mappings({})
    UmsReceiveAddress req2Address(UpdateAddressRequest request);
}
