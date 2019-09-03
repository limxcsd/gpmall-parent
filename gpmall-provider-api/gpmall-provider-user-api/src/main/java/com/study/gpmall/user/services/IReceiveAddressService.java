package com.study.gpmall.user.services;

import com.study.gpmall.user.dto.user.*;

/**
 * @ClassName: IMemberAddress
 * @Description: 会员收货地址
 * @author: Adminstrator
 * @Date: 2019-08-25 17:43
 */
public interface IReceiveAddressService {
    /**
     * 添加收货地址
     * @param request
     * @return
     */
    AddAddressResponse createAddress(AddAddressRequest request);

    /**
     * 删除会员收货地址
     * @param request
     * @return
     */
    DeleteAddressResponse deleteAddress(DeleteAddressRequest request);

    /**
     * 更新会员收货地址
     * @param request
     * @return
     */
    UpdateAddressResponse updateAddress(UpdateAddressRequest request);

    /**
     * 根据会员ID获取收货地址列表
     * @param request
     * @return
     */
    AddressListResponse getAddressList(AddressListRequest request);
}
