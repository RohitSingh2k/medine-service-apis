package com.sample.phm.exception;

public class SaleQunatityGreaterThanStockException extends Exception{
    public SaleQunatityGreaterThanStockException() {
        super();
    }

    public SaleQunatityGreaterThanStockException(String message) {
        super(message);
    }

    public SaleQunatityGreaterThanStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaleQunatityGreaterThanStockException(Throwable cause) {
        super(cause);
    }

    protected SaleQunatityGreaterThanStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
