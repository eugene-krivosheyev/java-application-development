package demo;

public class PolymorphismDemo {
    public static void main(String[] args) {
        LogSaver loggerWriter = new ConsoleLoggerWriter();
    }
}

class Controller {
    private LogSaver writer = new ConsoleLoggerWriter();

    public void log(String message) {
        writer.write(message);

    }
}
