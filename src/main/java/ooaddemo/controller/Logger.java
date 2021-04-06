package ooaddemo.controller;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.MessageFilter;
import ooaddemo.domain.message.Message;
import ooaddemo.printer.MessagePrinter;

/**
 * Code reuse: inheritance | delegation | frameworks (IoC) | Generic programming | HOF
 */
public class Logger extends ValidatingLogger {
    //TODO: Creational problem -> Creational DP
    private final MessageFilter filter;
    private final MessagePrinter printer;

    //constructor DI
    public Logger(MessageFilter filter, MessagePrinter printer) {
        this.filter = filter;
        this.printer = printer;
    }

    //Algo: OCP
    public void log(Message message, SeverityLevel severity) { //0,1,2
        this.validate(message, severity);

        if (filter.filter(message, severity)) {
            printer.print(message);
//            System.out.println(filter.getThreshold());
        }
    }
}
