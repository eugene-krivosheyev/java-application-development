package logger;

public class Logger {
    private LoggerFilter filter = new SeverityLevelLoggerFilter(); //Creator
    private LoggerSaver saver; //DI

    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message) {
        if(filter.filter(message)) {
            try {
                saver.save(message);
            } catch (RuntimeException e) {
//                e.printStackTrace();
                throw new LogOperationException(e);
            }
            System.out.println("2");
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
