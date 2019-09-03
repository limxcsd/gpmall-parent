package com.study.gpmall.user.dto.user;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: UpdateAddressRequest
 * @Description: 删除收货地址请求参数
 * @author: Adminstrator
 * @Date: 2019-08-25 18:08
 */
@Data
@ApiModel("更新收货地址请求参数")
public class UpdateAddressRequest extends AbstractRequest {
    private Long memberId;

    private String username;

    private String phoneNumber;

    private Integer defaultStatus;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String detailAddress;

    @Override
    public void requestCheck() {
        if(null == memberId || StringUtils.isBlank(phoneNumber)){
            throw new ValidateException(
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode(),
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
