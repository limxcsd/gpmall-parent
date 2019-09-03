package com.study.gpmall.user.dto.member;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import com.study.gpmall.common.result.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: QueryMemberRequest
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-26 16:15
 */
@Data
@ApiModel("请求获取会员信息参数")
public class QueryMemberRequest extends AbstractRequest {
    @ApiModelProperty("会员ID")
    private Long memberId;

    @Override
    public void requestCheck() {
        if (memberId == null) {
            throw new ValidateException(
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    ResultCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
