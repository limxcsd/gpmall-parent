package com.study.gpmall.common.exception;

import com.study.gpmall.common.result.AbstractResponse;

/**
 * @ClassName: ExceptionUtils
 * @Description: 统一异常处理工具类
 * @author: limingxing
 * @Date: 2019-08-21 11:11
 */
public class ExceptionUtils {

    /**
     * 将下层抛出的异常转换为resp返回码
     *
     * @param e Exception
     * @return
     */
    public static AbstractResponse handlerException4biz(AbstractResponse response, Exception e) throws Exception {
        Exception ex = null;
        if (!(e instanceof Exception)) {
            return null;
        }
        if (e instanceof ValidateException) {
            response.setCode(((ValidateException) e).getErrorCode());
            response.setMsg(e.getMessage());
        }else if(e instanceof ProcessException) {
            response.setCode(((ProcessException) e).getErrorCode());
            response.setMsg(e.getMessage());
        }else if(e instanceof BizException) {
            response.setCode(((BizException) e).getErrorCode());
            response.setMsg(e.getMessage());
        }else if (e instanceof Exception) {
            throw e; //处理不了，抛出去调用方处理
        }
        return response;
    }

}
