package com.study.gpmall.user.converter;

import com.study.gpmall.user.dal.entitys.UmsMember;
import com.study.gpmall.user.dto.login.UserLoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName: UserConverterMapper
 * @Description: UmsMember会员dto与实体转换
 * @author: limingxing
 * @Date: 2019-08-21 10:51
 */
@Mapper
public interface UserConverterMapper {

    UserConverterMapper INSTANCE = Mappers.getMapper(UserConverterMapper.class);

    @Mappings({})
    UserLoginResponse converter(UmsMember member);
}
