package ooaddemo;

public class ConsoleLogWriter implements LogWriter {
    public void write(String message) {
        System.out.println(message);
    }
}

