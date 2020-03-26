package ooaddemo;

/**
 * Mediator -> Controller
 */
public class Logger {
    private MessageLengthLogFilter filter = new MessageLengthLogFilter(10);
    private ConsoleLogWriter writer = new ConsoleLogWriter();

    public void log(String message, int messageSeverity) {
        if (filter.filter(message, messageSeverity)) {
            writer.write(message);
        }
    }
}
