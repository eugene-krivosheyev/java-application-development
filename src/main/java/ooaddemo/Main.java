package ooaddemo;

public class Main {
    public static void main(String[] args) {
        final Logger logger = new Logger(
                new ConsoleLogWriter(),
                new MessageLengthLogFilter(10)
        );
    }
}
