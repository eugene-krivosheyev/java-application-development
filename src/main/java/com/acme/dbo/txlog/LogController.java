package com.acme.dbo.txlog;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogController {

    private static final Logger LOG = Logger.getLogger(LogController.class.getName());

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
        try {
            logWriter.write(previousCommand);
        } catch (LogException e) {
            LOG.log(Level.SEVERE, "unable to write log {}", command);
        }
    }

    public void flush() {
        writeAccordingBusinessRules(previousCommand);
        previousCommand = null;
    }

}