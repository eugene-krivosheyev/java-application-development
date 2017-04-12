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
                throw new LogOperationException(e);
            } finally { //Replaced by t-w-r
                if(saver != null) {
                    try {
                        saver.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
