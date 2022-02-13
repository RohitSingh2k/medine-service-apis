package com.sample.phm.exception;

public class BadMedicineCredentialException extends Exception{
    public BadMedicineCredentialException() {
        super();
    }

    public BadMedicineCredentialException(String message) {
        super(message);
    }

    public BadMedicineCredentialException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadMedicineCredentialException(Throwable cause) {
        super(cause);
    }

    protected BadMedicineCredentialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
