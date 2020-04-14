package com.acme.dbo.txlog;

public class LoggerController {
    private final LogWriter logWriter;
    private Command currentCommand;

    public LoggerController(LogWriter logWriter) {
        this.currentCommand = new NullCommand();
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if (sameCommand(command)) {
            updateCommand(command);
        } else {
            flush(command);
        }
    }

    public void flush() {
        flush(new NullCommand());
    }

    private boolean sameCommand(Command command) {
        return this.currentCommand.isSame(command);
    }

    private void updateCommand(Command command) {
        try {
            this.currentCommand = currentCommand.accumulate(command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.flush(command);
        }
    }

    private void flush(Command command) {
        if (!(this.currentCommand instanceof NullCommand)) {
            logWriter.write(this.currentCommand);
        }
        this.currentCommand = command;
    }
}
