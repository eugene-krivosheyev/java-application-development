package ooadlogger;

public class LoggerController {
    private LogWriter logWriter;
    private Command currentState;

    public LoggerController(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    public void log(Command command) {
        if (sameCommand(command)) {
            updateState(command);
        } else {
            flush(command);
        }
    }

    private boolean sameCommand(Command command) {
        return false; //currentState.isSame(command);
    }

    private void updateState(Command command) {
//        this.currentState = currentState.accumulate(command);
    }

    private void flush(Command command) {
        logWriter.write(this.currentState);
        this.currentState = command;
    }
}
