package com.self.vuebackend.exception;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {

    /**
     * 异常错误码
     */
    private Integer errorCode;

    public BizException(Integer errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable throwable){
        super(errorMsg, throwable);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
