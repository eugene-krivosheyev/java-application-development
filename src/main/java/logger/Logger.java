package logger;

public class Logger {
    private LoggerFilter filter = new SeverityLevelLoggerFilter(); //Creator
    private LoggerSaver saver; //DI

    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message) {
        if(filter.filter(message)) {
            RuntimeException mainFlowException = null;
            try {
                saver.save(message);
            } catch (RuntimeException e) {
                mainFlowException = new LogOperationException(e);
                throw mainFlowException;
            } finally { //Replaced by t-w-r
                try {
                    saver.close();
                } catch (RuntimeException e) {
                    e.addSuppressed(mainFlowException);
                    throw e;
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Logger logger = new Logger(null);
        logger.log("test");
        System.out.println("3");
    }
}
