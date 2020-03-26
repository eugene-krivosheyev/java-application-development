package ooaddemo;

public class Logger {
    private LogWriter writer = new LogWriter(0);

    public void log(String message, int severityLevel) {
        Severity3LogFilter filter = new Severity3LogFilter(severityLevel);
        if (filter.filter(message)) {
            writer.write(message);
        }
    }
}
