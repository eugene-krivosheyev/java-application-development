package com.acme.dbo.txlog;

import java.io.IOException;

public interface ILogWriter extends AutoCloseable {
    void write(String message) throws WriteException, IOException;
}
