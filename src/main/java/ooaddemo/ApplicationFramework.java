package ooaddemo;

import ooaddemo.controller.LoggerController;
import ooaddemo.controller.ValidatingController;
import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.message.DecoratingMessage;
import ooaddemo.message.StringMessage;
import ooaddemo.printer.FilePrinter;

import java.sql.Connection;
import java.util.Objects;

import static ooaddemo.domain.SeverityLevel.WARNING;

/**
 * Application builder
 */
public class ApplicationFramework {
    public static void main(String[] args) {
        //region DI Framework
        final ValidatingController loggerController = new LoggerController(
                System.out::println,
                (DecoratingMessage message, SeverityLevel severity) -> WARNING.compareTo(severity) > 0
        );

        //endregion

        //region Request Cycle
        /*
        while (true) {
            getRemoteRequest(); //HTTP
            loggerController.log(...);
            sendResponse(); //HTTP
        }
         */
        //endregion
        loggerController.log(new StringMessage("message"), SeverityLevel.ERROR);
    }
}
