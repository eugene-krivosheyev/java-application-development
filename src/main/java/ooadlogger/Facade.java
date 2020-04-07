package ooadlogger;


public class Facade {
    private static LoggerController controller
            = new LoggerController(new ConsoleLogWriter());

    public static void log(int message) {
        controller.log(new IntCommand(message, new IntDecorator()));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }
}
