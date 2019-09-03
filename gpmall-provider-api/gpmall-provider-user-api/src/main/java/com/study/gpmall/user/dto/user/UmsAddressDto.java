package com.study.gpmall.user.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UmsAddressDto
 * @Description:
 * @author: Adminstrator
 * @Date: 2019-08-25 18:05
 */
@Data
public class UmsAddressDto implements Serializable {
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
