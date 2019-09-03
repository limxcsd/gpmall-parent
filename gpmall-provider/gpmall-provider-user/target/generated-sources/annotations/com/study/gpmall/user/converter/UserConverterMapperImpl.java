package com.study.gpmall.user.converter;

import com.study.gpmall.user.dal.entitys.UmsMember;
import com.study.gpmall.user.dto.login.UserLoginResponse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-03T18:56:06+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class UserConverterMapperImpl implements UserConverterMapper {

    @Override
    public UserLoginResponse converter(UmsMember member) {
        if ( member == null ) {
            return null;
        }

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        if ( member.getId() != null ) {
            userLoginResponse.setId( String.valueOf( member.getId() ) );
        }
        userLoginResponse.setUsername( member.getUsername() );
        userLoginResponse.setPhone( member.getPhone() );
        userLoginResponse.setIcon( member.getIcon() );
        userLoginResponse.setGender( member.getGender() );
        userLoginResponse.setIntegration( member.getIntegration() );

        return userLoginResponse;
    }
}
