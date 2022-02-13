package com.sample.phm.exception;

public class BadSalesCredentialsException extends Exception{
    public BadSalesCredentialsException() {
        super();
    }

    public BadSalesCredentialsException(String message) {
        super(message);
    }

    public BadSalesCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadSalesCredentialsException(Throwable cause) {
        super(cause);
    }

    protected BadSalesCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
