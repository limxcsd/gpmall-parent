package com.study.gpmall.user.dto.user;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: AddressListResponse
 * @Description: 根据会员id获取收货地址列表
 * @author: Adminstrator
 * @Date: 2019-08-25 18:02
 */
@Data
@ApiModel("根据会员id获取收货地址列表")
public class AddressListResponse extends AbstractResponse {
    List<UmsAddressDto> list;
}
