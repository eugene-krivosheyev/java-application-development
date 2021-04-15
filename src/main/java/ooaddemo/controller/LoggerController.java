package ooaddemo.controller;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.MessageFilter;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.message.DecoratingMessage;
import ooaddemo.printer.ConsolePrinter;
import ooaddemo.printer.Printer;

import java.io.IOException;

/**
 * Code reuse := responsibility delegation | inheritance | frameworks | generic progr | HOF
 *
 *  Inheritance = polymorphism + state and behavior reuse
 */
public class LoggerController extends ValidatingController {
    private final Printer printer;
    private final MessageFilter filter;

    /**
     * Constructor DI
     */
    public LoggerController(Printer printer, MessageFilter filter) {
        this.printer = printer;
        this.filter = filter;
    }

    @Override
    public Integer log(DecoratingMessage message, SeverityLevel severity) {
        super.log(message, severity);

        Printer.commonMethod();
        printer.instMethod();

        if (filter.filter(message, severity)) {
            try {
                printer.print(message.getDecoratedMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
