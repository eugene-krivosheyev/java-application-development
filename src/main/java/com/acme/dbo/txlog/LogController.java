package com.acme.dbo.txlog;

import java.util.Objects;

public class LogController {

    private Command previousCommand;
    private LogWriter logWriter = new ConsoleLogWriter();

    public void write(Command command) {
        if (Objects.isNull(previousCommand)) {
            previousCommand = command;
            return;
        }

        if (previousCommand.equals(command) && previousCommand.canBeBuffered(command)) {
            previousCommand = previousCommand.accumulate(command);
        } else {
            logWriter.write(previousCommand);
            previousCommand = command;
        }
    }

    public void flush() {
        logWriter.write(previousCommand);
        previousCommand = null;
    }

    public void setDecorated(boolean decorated) {
        logWriter.setDecorated(decorated);
    }
}