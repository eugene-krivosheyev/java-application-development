package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.LoggingType;
import com.acme.dbo.txlog.message.ByteDecoratingMessage;
import com.acme.dbo.txlog.message.DecoratingMessage;
import com.acme.dbo.txlog.message.IntDecoratingMessage;
import com.acme.dbo.txlog.printer.Printer;

public class LoggerController {

    public static final String LOGGING_TYPE_INT = "int";
    public static final String LOGGING_TYPE_BYTE = "byte";
    public static final String LOGGING_TYPE_STRING = "string";

    private LoggingType lastLoggedType = null;

    private final Printer printer;

    private DecoratingMessage lastIntMessage = null;
    private DecoratingMessage lastByteMessage = null;

    public LoggerController(final Printer printer) {
        this.printer = printer;
    }

    public void log(final DecoratingMessage message) {
        this.flush();
        printer.print(message.getDecoratedMessage());
    }

    public void log(final IntDecoratingMessage message) {
        if (!LoggingType.INT.equals(lastLoggedType)) {
            this.flush();
        }
        lastIntMessage = logNumber(lastIntMessage, message);
        lastLoggedType = LoggingType.INT;
    }

    public void log(final ByteDecoratingMessage message) {
        if (!LoggingType.BYTE.equals(lastLoggedType)) {
            this.flush();
        }
        lastByteMessage = logNumber(lastByteMessage, message);
        lastLoggedType = LoggingType.BYTE;
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

    public void flush() {
        if (LoggingType.INT.equals(lastLoggedType)) {
            printer.print(lastIntMessage.getDecoratedMessage());
        } else if (LoggingType.BYTE.equals(lastLoggedType)) {
            printer.print(lastByteMessage.getDecoratedMessage());
        } else if (LoggingType.STRING.equals(lastLoggedType)) {
            printer.print("Not supported yet");
        }

        this.resetState();
    }

    private void resetState() {
        lastLoggedType = null;
        lastIntMessage = null;
        lastByteMessage = null;
    }
}
