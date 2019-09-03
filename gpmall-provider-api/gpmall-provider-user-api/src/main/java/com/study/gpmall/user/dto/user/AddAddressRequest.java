package com.study.gpmall.user.dto.user;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: AddAddressRequest
 * @Description: 添加会员收货地址请求
 * @author: Adminstrator
 * @Date: 2019-08-25 17:51
 */
@Data
@ApiModel("添加会员收货地址请求")
public class AddAddressRequest extends AbstractRequest {
    @ApiModelProperty(value = "会员id")
    private Long memberId;
    @ApiModelProperty(value = "收货人性名")
    private String username;
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;
    @ApiModelProperty(value = "是否默认收货地址")
    private Integer defaultStatus;
    @ApiModelProperty(value = "详细地址(街道)")
    private String detailAddress;
    @Override
    public void requestCheck() {
        if(null == memberId || StringUtils.isBlank(username)||StringUtils.isBlank(phoneNumber)){
            throw new ValidateException(
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
