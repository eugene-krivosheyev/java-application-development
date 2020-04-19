package com.acme.dbo.txlog;

public interface LogWriter {

    void write(Command command);

    void write(String command);
}
