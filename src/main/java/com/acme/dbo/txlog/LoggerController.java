package com.acme.dbo.txlog;

import com.acme.dbo.txlog.Command;

public class LoggerController {
    private LogWriter logWriter;
    private Command currentState;

    public LoggerController(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if(sameCommand(command) && currentState.checkOverflow(command)) {
            updateState(command);
        } else {
            flush(command);
        }
    }

    private boolean sameCommand(Command command) {
        if(currentState != null) {
            return currentState.isSame(command);
        } else {
            return false;
        }
    }

    private void updateState(Command command) {
        this.currentState = currentState.accumulateCommand(command);
    }

    private void flush(Command command) {
        if(this.currentState != null) {
            logWriter.write(this.currentState);
        }
        this.currentState = command;

    }

}
