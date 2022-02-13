package com.sample.phm.exception;

public class BadCompanyCredentialException extends Exception{
    public BadCompanyCredentialException() {
        super();
    }

    public BadCompanyCredentialException(String message) {
        super(message);
    }

    public BadCompanyCredentialException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCompanyCredentialException(Throwable cause) {
        super(cause);
    }

    protected BadCompanyCredentialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
