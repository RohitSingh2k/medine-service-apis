package com.sample.phm.exception;

public class UserNotFoundExcetion extends Exception{

    public UserNotFoundExcetion() {
        super();
    }

    public UserNotFoundExcetion(String message) {
        super(message);
    }

    public UserNotFoundExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundExcetion(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
