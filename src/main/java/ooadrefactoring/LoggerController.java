package ooadrefactoring;

public class LoggerController {
    private LoggerState currentState;
    private IntMessage currentStateIntValue; //state value
    private ConsolePrinter consolePrinter;

    public LoggerController(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void log(IntMessage newMessage) {
        if (currentStateIntValue.isSameTypeOf(newMessage)) {
            currentStateIntValue = currentStateIntValue.accumulate(newMessage);
        } else {

        }
    }

    public void log(StringMessage stringMessage) {
        if (currentState == LoggerState.STRING) {

        }
    }
}
