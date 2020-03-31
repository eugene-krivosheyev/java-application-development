package ooaddemo;

/**
 * Mediator -> Controller
 */
public class Logger {
    //DI: field
    private LogFilter filter;
    private LogWriter writer;

    //DI: constructor
    public Logger(LogFilter filter, LogWriter writer) {
        this.filter = filter;
        this.writer = writer;
    }

    //DI: setter
    public void setFilter(LogFilter filter) {
        this.filter = filter;
    }

    public void log(Command message, int messageSeverity) {
        if (filter.filter(message.getMessage(), messageSeverity)) {
            writer.write(message.getDecoratedMessage());
        }
    }
}
