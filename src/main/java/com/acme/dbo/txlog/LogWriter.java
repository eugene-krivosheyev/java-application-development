package com.acme.dbo.txlog;

public interface LogWriter {

    void write(Command command) throws LogException;

    void write(String command) throws LogException;
}
