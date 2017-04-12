package logger;

public class FileLoggerSaver implements LoggerSaver {
    public void save(String message) {
        if(true) throw new RuntimeException("Can't open file");
        System.out.println("1");
    }

    public void close() {

    }
}
