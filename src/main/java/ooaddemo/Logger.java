package ooaddemo;

public class Logger {
    private LogFilter filter = new LogFilter(5);
    private LogWriter writer = new LogWriter(0);

    public void log(String message) {
        if (filter.filter(message)) {
            writer.write(message);
        }
    }
}
