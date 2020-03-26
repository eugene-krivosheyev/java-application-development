package ooaddemo;

public class Logger {
    //field injection
    private LogWriter writer;
    private LogFilter filter;

    //Dependency Injection: constructor DI
    public Logger(LogWriter writer, LogFilter filter) {
        this.writer = writer;
        this.filter = filter;
    }

    //setter DI
    public void setWriter(LogWriter writer) {
        this.writer = writer;
    }

    public void log(String message, int severityLevel) {
        if (filter.filter(message)) {
            writer.write(message);
        }
    }
}
