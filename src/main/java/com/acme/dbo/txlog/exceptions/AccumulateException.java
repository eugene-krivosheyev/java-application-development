package com.acme.dbo.txlog.exceptions;

public class AccumulateException extends Exception {
    public AccumulateException() {
        super("Accumulate operation is not supported");
    }

    public AccumulateException(String message) {
        super(message);
    }
}
