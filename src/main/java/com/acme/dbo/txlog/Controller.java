package com.acme.dbo.txlog;


public class Controller {

    LogWriter logWriter;
    private Command currentState;

    public Controller(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if (command.isSame(currentState) &&
                command.updateNeeded(currentState)
        )
            this.currentState = command.updateState(currentState);
        else {
            flush();
            this.currentState = command;
        }

    }

    public void flush() {
        if (this.currentState != null) {
            logWriter.write(this.currentState);
            this.currentState = null;
        }

    }

}
