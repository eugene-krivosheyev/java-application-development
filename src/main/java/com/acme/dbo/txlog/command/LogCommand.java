package com.acme.dbo.txlog.command;

public interface LogCommand {
    String getValue();

    LogType getType();

    String getPrefix();
}
