package com.sample.phm.exception;

public class BadPurchaseHistoryCredentialsException extends Exception{
    public BadPurchaseHistoryCredentialsException() {
        super();
    }

    public BadPurchaseHistoryCredentialsException(String message) {
        super(message);
    }

    public BadPurchaseHistoryCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPurchaseHistoryCredentialsException(Throwable cause) {
        super(cause);
    }

    protected BadPurchaseHistoryCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
