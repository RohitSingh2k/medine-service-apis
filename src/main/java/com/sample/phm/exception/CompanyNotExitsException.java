package com.sample.phm.exception;

public class CompanyNotExitsException extends Exception {
    public CompanyNotExitsException() {
        super();
    }

    public CompanyNotExitsException(String message) {
        super(message);
    }

    public CompanyNotExitsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyNotExitsException(Throwable cause) {
        super(cause);
    }

    protected CompanyNotExitsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
