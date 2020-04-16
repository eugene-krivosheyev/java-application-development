package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.AccumulatedCommand;
import com.acme.dbo.txlog.command.LogCommand;

public class LogController {
    private LogCommand previousCommand;
    private LogWriter writer;

    public LogController(LogWriter writer) {
        this.writer = writer;
    }

    public void log(LogCommand command) {
        if (previousCommand != null && command instanceof AccumulatedCommand &&
                ((AccumulatedCommand) command).isCumulative(previousCommand))
            previousCommand = ((AccumulatedCommand) command).accumulateWith(previousCommand);
        else {
            writer.write(previousCommand);
            previousCommand = command;
        }
    }

    public void stop() {
        writer.write(previousCommand);
        previousCommand = null;
    }
}
