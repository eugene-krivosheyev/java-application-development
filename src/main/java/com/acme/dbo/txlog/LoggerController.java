package com.acme.dbo.txlog;

public class LoggerController {
    private final Printer printer;
    private final Filter filter;
    private Message currentMessage;

    public LoggerController(Printer printer, Filter filter) {
        this.printer = printer;
        this.filter = filter;
    }

    public void log(Message message, SevertyLevel logLevel) {
        if (filter.filter(message, logLevel)) {
            if (message.equals(currentMessage)) {
                currentMessage.accumulate(message);
            } else {
                if (currentMessage != null) {
                    printer.print(currentMessage.getDecoratedMessage());
                }
                currentMessage = message;
            }
        }
    }
}
