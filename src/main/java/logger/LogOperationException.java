package logger;

public class LogOperationException extends RuntimeException {
    public LogOperationException(RuntimeException e) {
        super(e);
    }
}
