package logger;

public class Logger {
    private LoggerFilter filter = new SeverityLevelLoggerFilter(); //Creator
    private LoggerSaver saver; //DI

    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message) {
        if(filter.filter(message)) {
            LoggerMessageFormatter formatter = null;
            try {
                formatter = new LoggerMessageFormatter();
                saver.save(formatter.format(message));
            } catch (RuntimeException e) {
                throw new LogOperationException(e);
            } finally { //Replaced by t-w-r
                try {
                    if(formatter != null) formatter.close();
                } catch (RuntimeException e) {
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Logger logger = new Logger(new FileLoggerSaver());
        logger.log("test");
        System.out.println("3");
    }
}
