package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: CheckAuthRequest
 * @Description: 请求校验参数
 * @author: limingxing
 * @Date: 2019-08-23 14:57
 */
@Data
@ApiModel("请求校验参数")
public class CheckAuthRequest extends AbstractRequest {
    @ApiModelProperty("token")
    private String token;

    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(token)){
            throw new ValidateException(
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
