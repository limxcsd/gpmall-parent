package com.study.gpmall.user.dto.user;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: DeleteAddressRequest
 * @Description: 删除收货地址请求参数
 * @author: Adminstrator
 * @Date: 2019-08-25 18:08
 */
@Data
@ApiModel("删除收货地址请求参数")
public class DeleteAddressRequest extends AbstractRequest {
    @ApiModelProperty(value = "地址id")
    private Long addredssId;

    @Override
    public void requestCheck() {
        if(null == addredssId){
            throw new ValidateException(
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode(),
                    ResultCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
