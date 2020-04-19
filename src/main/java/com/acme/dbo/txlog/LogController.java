package com.acme.dbo.txlog;

import java.util.Objects;

public class LogController {

    protected Command previousCommand;
    protected LogWriter logWriter;


    public LogController(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void write(Command command) {
        if (Objects.isNull(previousCommand)) {
            previousCommand = command;
        } else  if (previousCommand.canBeBuffered(command)) {
            previousCommand = previousCommand.accumulate(command);
        } else {
            writeAccordingBusinessRules(command);
            previousCommand = command;
        }
    }

    protected void writeAccordingBusinessRules(Command command){
        logWriter.write(previousCommand);
    }

    public void flush() {
        writeAccordingBusinessRules(previousCommand);
        previousCommand = null;
    }

}