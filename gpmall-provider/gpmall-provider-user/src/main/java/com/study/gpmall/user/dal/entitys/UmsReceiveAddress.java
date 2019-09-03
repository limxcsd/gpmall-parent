package com.study.gpmall.user.dal.entitys;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;

/**
 * @ClassName: UmsReceiveAddress
 * @Description: 会员收货地址实体
 * @author: limingxing
 * @Date: 2019-08-23 15:10
 */
@Data
@ToString
@Table(name = "ums_receive_address")
public class UmsReceiveAddress {
    private Long id;

    private Long memberId;

    private String username;

    private String phoneNumber;

    private Integer defaultStatus;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String detailAddress;


}
