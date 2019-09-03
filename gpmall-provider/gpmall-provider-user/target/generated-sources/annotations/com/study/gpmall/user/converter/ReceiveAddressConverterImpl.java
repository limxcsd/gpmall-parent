package com.study.gpmall.user.converter;

import com.study.gpmall.user.dal.entitys.UmsReceiveAddress;
import com.study.gpmall.user.dto.user.AddAddressRequest;
import com.study.gpmall.user.dto.user.UmsAddressDto;
import com.study.gpmall.user.dto.user.UpdateAddressRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-03T18:56:05+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class ReceiveAddressConverterImpl implements ReceiveAddressConverter {

    @Override
    public UmsAddressDto address2List(UmsReceiveAddress address) {
        if ( address == null ) {
            return null;
        }

        UmsAddressDto umsAddressDto = new UmsAddressDto();

        umsAddressDto.setId( address.getId() );
        umsAddressDto.setMemberId( address.getMemberId() );
        umsAddressDto.setUsername( address.getUsername() );
        umsAddressDto.setPhoneNumber( address.getPhoneNumber() );
        umsAddressDto.setDefaultStatus( address.getDefaultStatus() );
        umsAddressDto.setPostCode( address.getPostCode() );
        umsAddressDto.setProvince( address.getProvince() );
        umsAddressDto.setCity( address.getCity() );
        umsAddressDto.setRegion( address.getRegion() );
        umsAddressDto.setDetailAddress( address.getDetailAddress() );

        return umsAddressDto;
    }

    @Override
    public List<UmsAddressDto> address2List(List<UmsReceiveAddress> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<UmsAddressDto> list = new ArrayList<UmsAddressDto>( addresses.size() );
        for ( UmsReceiveAddress umsReceiveAddress : addresses ) {
            list.add( address2List( umsReceiveAddress ) );
        }

        return list;
    }

    @Override
    public UmsReceiveAddress req2Address(AddAddressRequest request) {
        if ( request == null ) {
            return null;
        }

        UmsReceiveAddress umsReceiveAddress = new UmsReceiveAddress();

        umsReceiveAddress.setMemberId( request.getMemberId() );
        umsReceiveAddress.setUsername( request.getUsername() );
        umsReceiveAddress.setPhoneNumber( request.getPhoneNumber() );
        umsReceiveAddress.setDefaultStatus( request.getDefaultStatus() );
        umsReceiveAddress.setDetailAddress( request.getDetailAddress() );

        return umsReceiveAddress;
    }

    @Override
    public UmsReceiveAddress req2Address(UpdateAddressRequest request) {
        if ( request == null ) {
            return null;
        }

        UmsReceiveAddress umsReceiveAddress = new UmsReceiveAddress();

        umsReceiveAddress.setMemberId( request.getMemberId() );
        umsReceiveAddress.setUsername( request.getUsername() );
        umsReceiveAddress.setPhoneNumber( request.getPhoneNumber() );
        umsReceiveAddress.setDefaultStatus( request.getDefaultStatus() );
        umsReceiveAddress.setPostCode( request.getPostCode() );
        umsReceiveAddress.setProvince( request.getProvince() );
        umsReceiveAddress.setCity( request.getCity() );
        umsReceiveAddress.setRegion( request.getRegion() );
        umsReceiveAddress.setDetailAddress( request.getDetailAddress() );

        return umsReceiveAddress;
    }
}
