package com.study.gpmall.user.services.impl;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ExceptionProcessorUtils;
import com.study.gpmall.user.converter.ReceiveAddressConverter;
import com.study.gpmall.user.dal.entitys.UmsReceiveAddress;
import com.study.gpmall.user.dal.mapper.UmsReceiveAddressMapper;
import com.study.gpmall.user.dto.user.*;
import com.study.gpmall.user.services.IReceiveAddressService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName: MemberAddressServiceImpl
 * @Description: 会员收货地址Service接口实现
 * @author: Adminstrator
 * @Date: 2019-08-25 20:00
 */
@Slf4j
@Service
public class ReceiveAddressServiceImpl implements IReceiveAddressService {
    @Autowired
    private UmsReceiveAddressMapper addressMapper;
    @Autowired
    private ReceiveAddressConverter addressConverter;

    @Override
    public AddAddressResponse createAddress(AddAddressRequest request) {
        log.error("MemberAddressServiceImpl.createAddress request : {}", request);
        AddAddressResponse response = new AddAddressResponse();
        try {
            UmsReceiveAddress address = addressConverter.req2Address(request);
            checkAddressDefaultUnique(request.getDefaultStatus(), request.getMemberId());
            int row = addressMapper.insert(address);
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
            log.info("MemberAddressServiceImpl.createAddress effect row : {}", row);
        } catch (Exception e) {
            log.error("MemberAddressServiceImpl.addAddress Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        log.error("MemberAddressServiceImpl.deleteAddress request : {}", request);
        DeleteAddressResponse response = new DeleteAddressResponse();
        try {
            request.requestCheck();
            int row = addressMapper.deleteByPrimaryKey(request.getAddredssId());
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
            log.info("MemberAddressServiceImpl.deleteAddress effect row : {}", row);
        } catch (Exception e) {
            log.error("MemberAddressServiceImpl.deleteAddress Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {
        log.error("MemberAddressServiceImpl.updateAddress request: {}", request);
        UpdateAddressResponse response = new UpdateAddressResponse();
        try {
            request.requestCheck();
            UmsReceiveAddress address = addressConverter.req2Address(request);
            int row = addressMapper.updateByPrimaryKey(address);
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
            log.info("MemberAddressServiceImpl.updateAddress effect row : {}", row);
        } catch (Exception e) {
            log.error("MemberAddressServiceImpl.updateAddress Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AddressListResponse getAddressList(AddressListRequest request) {
        log.error("MemberAddressServiceImpl.getAddressList request: {}", request);
        AddressListResponse response = new AddressListResponse();
        try {
            request.requestCheck();
            Example example = new Example(UmsReceiveAddress.class);
            example.createCriteria().andEqualTo("memberId", request.getMemberId());
            List<UmsReceiveAddress> list = addressMapper.selectByExample(example);
            response.setList(addressConverter.address2List(list));
            response.setCode(ResultCodeConstants.SUCCESS.getCode());
            response.setMsg(ResultCodeConstants.SUCCESS.getMessage());
            log.info("MemberAddressServiceImpl.getAddressList effect list : {}", list);
        } catch (Exception e) {
            log.error("MemberAddressServiceImpl.getAddressList Occur Exception : {}", e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    /**
     * @param defaultStatus
     * @param memberId
     */
    private void checkAddressDefaultUnique(Integer defaultStatus, Long memberId) {
        if (defaultStatus.equals(1)) {
            Example example = new Example(UmsReceiveAddress.class);
            example.createCriteria().andEqualTo("memberId", memberId);
            List<UmsReceiveAddress> addresses = addressMapper.selectByExample(example);
            addresses.parallelStream().forEach(address -> {
                if (address.getDefaultStatus().equals(Integer.parseInt("1"))) {
                    address.setDefaultStatus(0);
                    int row = addressMapper.updateByPrimaryKey(address);
                    System.out.println(address.getDefaultStatus() + "----> row : " + row);
                }
            });
        }
    }

}
