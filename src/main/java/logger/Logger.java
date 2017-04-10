package logger;

public class Logger {
    private LoggerFilter filter = new SeverityLevelLoggerFilter(); //Creator
    private LoggerSaver saver; //DI

    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message) {
        if(filter.filter(message)) {
            saver.save(message);
        }
    }
}
