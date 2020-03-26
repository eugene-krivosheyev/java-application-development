package ooaddemo;

public class LogWriterFactory {
    public static LogWriter create() {
        return new ConsoleLogWriter();
    }
}
