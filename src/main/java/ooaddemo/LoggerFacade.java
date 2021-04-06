package ooaddemo;

import ooaddemo.controller.Logger;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.message.IntMessage;
import ooaddemo.printer.ConsoleMessagePrinter;

public class LoggerFacade {
    private static Logger logger = new Logger(
            new SeverityMessageFilter(2),
            new ConsoleMessagePrinter()
    );

    public static void log(int message, int severity) {
        logger.log(new IntMessage(message), severity);
    }
}
