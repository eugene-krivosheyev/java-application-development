package com.acme.dbo.txlog;

public class IncompatibleValueException extends RuntimeException {

    public IncompatibleValueException(String message) {
        super(message);
    }

    public IncompatibleValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
