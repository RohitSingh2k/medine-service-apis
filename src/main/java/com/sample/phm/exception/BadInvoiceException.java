package com.sample.phm.exception;

public class BadInvoiceException extends Exception{
    public BadInvoiceException() {
        super();
    }

    public BadInvoiceException(String message) {
        super(message);
    }

    public BadInvoiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadInvoiceException(Throwable cause) {
        super(cause);
    }

    protected BadInvoiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
