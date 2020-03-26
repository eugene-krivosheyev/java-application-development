package ooaddemo;

public class LogFilterFactory {
    public static LogFilter create() {
        return new MessageLengthLogFilter(10);
    }
}
