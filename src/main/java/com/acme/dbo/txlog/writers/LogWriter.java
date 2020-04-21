package com.acme.dbo.txlog.writers;

import com.acme.dbo.txlog.commands.Command;

public interface LogWriter {
    void write(Command command);
}
