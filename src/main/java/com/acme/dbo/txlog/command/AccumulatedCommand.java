package com.acme.dbo.txlog.command;

public interface AccumulatedCommand {
    boolean isCumulative(LogCommand previousCommand);

    LogCommand accumulateWith(LogCommand previousCommand);
}
