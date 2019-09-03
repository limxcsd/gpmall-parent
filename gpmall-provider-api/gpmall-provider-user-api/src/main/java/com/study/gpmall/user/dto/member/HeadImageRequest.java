package com.study.gpmall.user.dto.member;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: HeadImageRequest
 * @Description: 请求修改用户头像参数
 * @author: limingxing
 * @Date: 2019-08-26 16:22
 */
@Data
@ApiModel("请求修改用户头像参数")
public class HeadImageRequest extends AbstractRequest {
    @ApiModelProperty("会员ID")
    private Long memberId;
    private String imageData;

    @Override
    public void requestCheck() {
        if (memberId == null) {
            throw new ValidateException(
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
