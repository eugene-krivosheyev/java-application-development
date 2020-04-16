package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.LogCommand;

public interface LogWriter {
    void write(LogCommand command);
}
