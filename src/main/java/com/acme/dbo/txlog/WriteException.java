package com.acme.dbo.txlog;

import java.io.IOException;

public class WriteException extends IOException {
    public WriteException(String message) {
        super(message);
    }

    public WriteException(String message, Throwable e) {
        super(message, e);
    }

    public WriteException(Throwable e) {
        super(e);
    }
}
