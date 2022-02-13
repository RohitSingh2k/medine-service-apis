package com.sample.phm.exception;

public class BadPurchaseException extends Exception{
    public BadPurchaseException() {
        super();
    }

    public BadPurchaseException(String message) {
        super(message);
    }

    public BadPurchaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPurchaseException(Throwable cause) {
        super(cause);
    }

    protected BadPurchaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
