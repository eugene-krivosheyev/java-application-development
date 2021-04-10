package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.ByteDecoratingMessage;
import com.acme.dbo.txlog.message.DecoratingMessage;
import com.acme.dbo.txlog.message.IntDecoratingMessage;
import com.acme.dbo.txlog.message.StringDecoratingMessage;
import com.acme.dbo.txlog.model.LoggingType;
import com.acme.dbo.txlog.printer.Printer;

import static com.acme.dbo.txlog.model.LoggingType.BYTE;
import static com.acme.dbo.txlog.model.LoggingType.INT;
import static com.acme.dbo.txlog.model.LoggingType.STRING;

public class LoggerController {

    private final Printer printer;

    private LoggingType lastLoggedType = null;

    private DecoratingMessage lastIntMessage = null;
    private DecoratingMessage lastByteMessage = null;
    private DecoratingMessage lastStringMessage = null;

    public LoggerController(final Printer printer) {
        this.printer = printer;
    }

    public void log(final DecoratingMessage message) {
        this.flush();
        printer.print(message.getDecoratedMessage());
    }

    public void log(final IntDecoratingMessage message) {
        if (!INT.equals(lastLoggedType)) {
            this.flush();
        }
        lastIntMessage = logNumber(lastIntMessage, message);
        lastLoggedType = INT;
    }

    public void log(final ByteDecoratingMessage message) {
        if (!BYTE.equals(lastLoggedType)) {
            this.flush();
        }
        lastByteMessage = logNumber(lastByteMessage, message);
        lastLoggedType = BYTE;
    }

    public DecoratingMessage logNumber(final DecoratingMessage lastMessage, final DecoratingMessage message) {
        if (lastMessage == null) {
            return message;
        }

        DecoratingMessage accumulatedMessage = lastMessage.accumulate(message);
        if (accumulatedMessage.equals(message)) {
            printer.print(lastMessage.getDecoratedMessage());
        }
        return accumulatedMessage;
    }

    public void log(final StringDecoratingMessage message) {
        if (!STRING.equals(lastLoggedType)) {
            this.flush();
        }

        DecoratingMessage accumulatedMessage = message;
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
        if (INT.equals(lastLoggedType)) {
            printer.print(lastIntMessage.getDecoratedMessage());
        } else if (BYTE.equals(lastLoggedType)) {
            printer.print(lastByteMessage.getDecoratedMessage());
        } else if (STRING.equals(lastLoggedType)) {
            printer.print(lastStringMessage.getDecoratedMessage());
        }

        this.resetState();
    }

    private void resetState() {
        lastLoggedType = null;
        lastIntMessage = null;
        lastByteMessage = null;
        lastStringMessage = null;
    }
}
