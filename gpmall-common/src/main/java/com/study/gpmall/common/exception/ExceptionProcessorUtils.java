package com.study.gpmall.common.exception;

import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.result.AbstractResponse;

/**
 * @ClassName: ExceptionProcessorUtils
 * @Description: 异常处理过程
 * @author: limingxing
 * @Date: 2019-08-21 11:09
 */
public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtils.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(ResultCodeConstants.SYSTEM_ERROR.getCode());
            response.setMsg(ResultCodeConstants.SYSTEM_ERROR.getMessage());
        }
    }
}
