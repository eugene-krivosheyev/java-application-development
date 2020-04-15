package com.acme.dbo.txlog;

import java.util.Objects;

public class LogController {
    private static LogWriter logWriter = new ConsoleLogWriter();
    private static Command currentState = null;

    public void log(Command command) {
        if (command.isNotAccumulatable()) {
            updateState(command);
        } else if (command.isDataOverloaded(currentState)) {
            writeCommand(currentState);
        }
        currentState = command.accumulate(currentState);
    }

    private void updateState(Command command) {
        writeCommand(command);
        currentState = command;
    }

    public void flush() {
        writeCommand(currentState);
        currentState = null;
    }

    private void writeCommand(Command command) {
        if (Objects.nonNull(command)) logWriter.write(command);
    }
}
