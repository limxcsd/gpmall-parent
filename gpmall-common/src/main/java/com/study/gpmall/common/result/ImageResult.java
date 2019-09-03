package com.study.gpmall.common.result;

import lombok.Data;

/**
 * @ClassName: ImageResult
 * @Description: 图片验证码返回
 * @author: limingxing
 * @Date: 2019-08-24 16:43
 */
@Data
public class ImageResult {
    String img;
    String code;
}
