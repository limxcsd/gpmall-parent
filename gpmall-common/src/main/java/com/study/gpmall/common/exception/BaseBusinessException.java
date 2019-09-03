package com.study.gpmall.common.exception;

/**
 * @ClassName: BaseBusinessException
 * @Description:
 * @author: limingxing
 * @Date: 2019-08-21 10:34
 */
public class BaseBusinessException extends RuntimeException{
    protected String          errorCode;

    protected String          message;

    protected String        extFields;

    public BaseBusinessException() {
        super();
    }

    public BaseBusinessException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BaseBusinessException(Throwable arg0) {
        super(arg0);
    }

    public BaseBusinessException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BaseBusinessException(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

    public BaseBusinessException(String errorCode, String message, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.message = message;
    }

    public BaseBusinessException(String errorCode, String message,String extFields, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.message = message;
        this.extFields=extFields;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }
}
