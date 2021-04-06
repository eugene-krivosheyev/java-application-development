package ooaddemo;

public class LoggerFacade {
    private static Logger logger = new Logger(
            new SeverityMessageFilter(2),
            new ConsoleMessagePrinter()
    );

    public static void log(int message, int severity) {
        logger.log(new IntMessage(message), severity);
    }
}
