package com.study.gpmall.user.dto.login;

import com.study.gpmall.common.result.AbstractResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: CheckAuthResponse
 * @Description: 校验过程用户token返回
 * @author: limingxing
 * @Date: 2019-08-23 14:58
 */
@Data
@ApiModel("校验过程用户token返回")
public class CheckAuthResponse extends AbstractResponse {
    @ApiModelProperty(value = "用户")
    private String userinfo;
}

