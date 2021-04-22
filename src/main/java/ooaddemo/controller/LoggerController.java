package ooaddemo.controller;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.MessageFilter;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.message.DecoratingMessage;
import ooaddemo.printer.ConsolePrinter;
import ooaddemo.printer.Printer;

import java.io.IOException;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * Code reuse := responsibility delegation | inheritance | frameworks | generic progr | HOF
 *
 *  Inheritance = polymorphism + state and behavior reuse
 */
public final class LoggerController extends ValidatingController {
    private final Consumer<String> printer;
    private final BiPredicate<DecoratingMessage, SeverityLevel> filter;

    /**
     * Constructor DI
     */
    public LoggerController(Consumer<String> printer, BiPredicate<DecoratingMessage, SeverityLevel> filter) {
        super(0);
        this.printer = printer;
        this.filter = filter;
    }

    public LoggerController() {
        this(null,null); // XOR super()
    }

    @Override
    public final Integer log(DecoratingMessage message, SeverityLevel severity) {
        super.log(message, severity);

        Printer.commonMethod();
//        printer.instMethod();

        if (filter.test(message, severity)) {
            printer.accept(message.getDecoratedMessage());
        }

        return null;
    }
}
