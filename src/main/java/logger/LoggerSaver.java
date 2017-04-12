package logger;

public interface LoggerSaver {
    void save(String message);
    void close();
}
