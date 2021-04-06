package ooaddemo;

import ooaddemo.controller.Logger;
import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.domain.message.IntMessage;
import ooaddemo.printer.ConsoleMessagePrinter;

import static ooaddemo.domain.SeverityLevel.DEBUG;

public class LoggerFacade {
    private static Logger logger = new Logger(
            new SeverityMessageFilter(DEBUG),
            new ConsoleMessagePrinter()
    );

    public static void log(int message, SeverityLevel severity) {
        logger.log(new IntMessage(message), severity);
    }
}
