package com.study.gpmall.user.dto.user;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: AddressListRequest
 * @Description: 获取收货地址列表请求参数
 * @author: Adminstrator
 * @Date: 2019-08-25 19:51
 */
@Data
@ApiModel("获取收货地址列表请求参数")
public class AddressListRequest extends AbstractRequest {
    @ApiModelProperty("会员ID")
    private Long memberId;
    @Override
    public void requestCheck() {
        if(null == memberId ){
            throw new ValidateException(
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode(),
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
