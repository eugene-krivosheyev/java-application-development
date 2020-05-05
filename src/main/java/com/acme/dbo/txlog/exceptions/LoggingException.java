package com.acme.dbo.txlog.exceptions;

public class LoggingException extends Exception {

    public LoggingException(Exception e) {
    }

    public LoggingException(String message) {
        super(message);
    }

    public LoggingException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggingException(Throwable cause) {
        super(cause);
    }
}
