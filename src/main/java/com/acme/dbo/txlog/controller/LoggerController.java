package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.AccumulatingMessage;
import com.acme.dbo.txlog.message.DecoratingMessage;
import com.acme.dbo.txlog.message.NumberDecoratingMessage;
import com.acme.dbo.txlog.message.StringDecoratingMessage;
import com.acme.dbo.txlog.model.LoggingType;
import com.acme.dbo.txlog.printer.Printer;

import static com.acme.dbo.txlog.model.LoggingType.BYTE;
import static com.acme.dbo.txlog.model.LoggingType.INT;
import static com.acme.dbo.txlog.model.LoggingType.STRING;

public class LoggerController {

    private final Printer printer;

    private LoggingType lastLoggedType = null;

    private AccumulatingMessage lastNumberMessage = null;
    private AccumulatingMessage lastStringMessage = null;

    public LoggerController(final Printer printer) {
        this.printer = printer;
    }

    public void log(final DecoratingMessage message) {
        this.flush();
        printer.print(message.getDecoratedMessage());
    }

    public void log(final NumberDecoratingMessage message, final LoggingType loggingType) {
        if (!loggingType.equals(lastLoggedType)) {
            this.flush();
        }
        lastNumberMessage = logNumber(lastNumberMessage, message);
        lastLoggedType = loggingType;
    }

    public AccumulatingMessage logNumber(final AccumulatingMessage lastMessage, final AccumulatingMessage message) {
        if (lastMessage == null) {
            return message;
        }

        AccumulatingMessage accumulatedMessage = lastMessage.accumulate(message);
        if (accumulatedMessage.equals(message)) {
            printer.print(((DecoratingMessage) lastMessage).getDecoratedMessage());
        }
        return accumulatedMessage;
    }

    public void log(final StringDecoratingMessage message) {
        if (!STRING.equals(lastLoggedType)) {
            this.flush();
        }

        AccumulatingMessage accumulatedMessage = message;
        if (lastStringMessage != null) {
            accumulatedMessage = lastStringMessage.accumulate(message);
            if (accumulatedMessage.equals(message)) {
                this.flush();
            }
        }

        lastStringMessage = accumulatedMessage;
        lastLoggedType = STRING;
    }

    public void flush() {
        if (INT.equals(lastLoggedType) || BYTE.equals(lastLoggedType)) {
            printer.print(((DecoratingMessage) lastNumberMessage).getDecoratedMessage());
        } else if (STRING.equals(lastLoggedType)) {
            printer.print(((DecoratingMessage) lastStringMessage).getDecoratedMessage());
        }

        this.resetState();
    }

    private void resetState() {
        lastLoggedType = null;
        lastNumberMessage = null;
        lastStringMessage = null;
    }
}
