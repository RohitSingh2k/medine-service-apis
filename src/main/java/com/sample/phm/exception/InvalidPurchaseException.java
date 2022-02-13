package com.sample.phm.exception;

public class InvalidPurchaseException extends Exception{
    public InvalidPurchaseException() {
        super();
    }

    public InvalidPurchaseException(String message) {
        super(message);
    }

    public InvalidPurchaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPurchaseException(Throwable cause) {
        super(cause);
    }

    protected InvalidPurchaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
