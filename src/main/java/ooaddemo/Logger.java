package ooaddemo;

public class Logger {
    private LogWriter writer = new ConsoleLogWriter();
    private LogFilter filter = new MessageLengthLogFilter(10);

    public void log(String message, int severityLevel) {
        if (filter.filter(message)) {
            writer.write(message);
        }
    }
}
