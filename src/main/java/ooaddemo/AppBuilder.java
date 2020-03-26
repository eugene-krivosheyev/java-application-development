package ooaddemo;

public class AppBuilder {
    public static void main(String[] args) {
        final Logger logger = new Logger(
                new MessageLengthLogFilter(10),
                new ConsoleLogWriter()
        );

        logger.log("HW!!!", 2);
    }
}
