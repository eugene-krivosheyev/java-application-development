package com.acme.dbo.txlog;

public interface LogWriter {
    void write(Command command);

    String decorate(Command command);

    void setDecorated(boolean decorated);
}
