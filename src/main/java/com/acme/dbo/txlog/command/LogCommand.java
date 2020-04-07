package com.acme.dbo.txlog.command;

public interface LogCommand {
    String getPrefix();

    String getValue();
}
