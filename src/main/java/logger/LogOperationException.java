package logger;

public class LogOperationException extends Exception {
    public LogOperationException(RuntimeException e) {
        super(e);
    }
}
