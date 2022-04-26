package com.acme.dbo.txlog;

import java.util.Objects;

import static com.acme.dbo.txlog.decorator.MessageDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade<T> {
    private static MessageTypes lastMessageDataType = MessageTypes.NULL;

    private static int intAccumulator;

    private static byte byteAccumulator;

    private static String stringBuffer;
    private static int stringAccumulator;

    public static void log (int message) {
        if (lastMessageDataType != MessageTypes.INT ||
                (Integer.signum(intAccumulator) == Integer.signum(message) &&
                 Integer.signum(intAccumulator) != Integer.signum(intAccumulator + message))) {
            flush();
        }
        intAccumulator += message;
        lastMessageDataType = MessageTypes.INT;
    }

    public static void log (byte message) {
        if (lastMessageDataType != MessageTypes.BYTE ||
                (Integer.signum(byteAccumulator) == Integer.signum(message) &&
                 Integer.signum(byteAccumulator) != Integer.signum((byte)(byteAccumulator + message)))) {
            flush();
        }
        byteAccumulator += message;
        lastMessageDataType = MessageTypes.BYTE;
    }

    public static void log (char message) {
        lastMessageDataType = MessageTypes.CHAR;
        push(message);
    }

    public static void log (String message) {
        if (lastMessageDataType != MessageTypes.STRING || !Objects.equals(message, stringBuffer)) {
            flush();
        }
        stringBuffer = message;
        stringAccumulator++;
        lastMessageDataType = MessageTypes.STRING;
    }

    public static void log (Object message) {
        lastMessageDataType = MessageTypes.OBJECT;
        push(message);
    }

    public static void flush () {
        switch (lastMessageDataType) {
            case INT:    push(intAccumulator);
                              intAccumulator = 0;
                              break;
            case BYTE:   push(byteAccumulator);
                              byteAccumulator = 0;
                              break;
            case STRING: push(stringAccumulator == 1 ?
                              stringBuffer :
                              String.format("%s (x%d)", stringBuffer, stringAccumulator));
                              stringAccumulator = 0;
                              break;
        }
    }

    private static <T> void push(T message) {
        print(decorate(message));
    }

    private enum MessageTypes {
        NULL,
        INT,
        BYTE,
        CHAR,
        STRING,
        OBJECT;
    }
}
