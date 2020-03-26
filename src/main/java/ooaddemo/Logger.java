package ooaddemo;

public class Logger {
    private LogWriter writer = new ConsoleLogWriter(); //Creator
    private LogFilter filter = LogFilterFactory.create(); //Factory Method

    public void log(String message, int severityLevel) {
        if (filter.filter(message)) {
            writer.write(message);
        }
    }
}
