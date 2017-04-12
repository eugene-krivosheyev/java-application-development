package logger;

public class Logger {
    private LoggerFilter filter = new SeverityLevelLoggerFilter(); //Creator
    private LoggerSaver saver; //DI

    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message) throws LogOperationException {
        if(filter.filter(message)) {
            try (LoggerMessageFormatter formatter = new LoggerMessageFormatter()) {
                saver.save(formatter.format(message));
            } catch (RuntimeException e) {
                throw new LogOperationException(e);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Logger logger = new Logger(new FileLoggerSaver());
        try {
            logger.log("test");
        } catch (LogOperationException e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }
}
