package com.sample.phm.exception;

public class PurchaseNotFoundException extends Exception{
    public PurchaseNotFoundException() {
        super();
    }

    public PurchaseNotFoundException(String message) {
        super(message);
    }

    public PurchaseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PurchaseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PurchaseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
