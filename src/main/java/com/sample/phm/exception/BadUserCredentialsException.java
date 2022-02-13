package com.sample.phm.exception;

public class BadUserCredentialsException extends Exception{
    public BadUserCredentialsException() {
        super();
    }

    public BadUserCredentialsException(String message) {
        super(message);
    }

    public BadUserCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadUserCredentialsException(Throwable cause) {
        super(cause);
    }

    protected BadUserCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
