package com.study.gpmall.common.result;

/**
 * @ClassName: ResponseData
 * @Description: 统一返回数据
 * @author: limingxing
 * @Date: 2019-08-21 16:03
 */
public class ResponseData<T> {

    private boolean success;

    private String message; //消息

    private int code;

    private T result; //返回的数据


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
