package ooaddemo;

/**
 * Mediator -> Controller
 */
public class Logger {
    private LogFilter filter = new MessageSeverityLogFilter(3);
    private LogWriter writer = LogWriterFactory.create(); //Factory method -> Abstract Method

    public void log(String message, int messageSeverity) {
        if (filter.filter(message, messageSeverity)) {
            writer.write(message);
        }
    }
}
