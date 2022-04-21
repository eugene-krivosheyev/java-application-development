package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.decorator.MessageDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade<T> {
    private static final String INT_TYPE = "int";
    private static final String BYTE_TYPE = "byte";
    private static final String CHAR_TYPE = "char";
    private static final String STRING_TYPE = "String";
    private static final String OBJECT_TYPE = "Object";

    private static String lastMessageDataType = "";

    private static int intAccumulator;

    private static byte byteAccumulator;

    private static String stringBuffer;
    private static int stringAccumulator;

    public static void log (int message) {
        if (lastMessageDataType != INT_TYPE) {
            flush();
        }
        intAccumulator += message;
        lastMessageDataType = INT_TYPE;
    }

    public static void log (byte message) {
        if (lastMessageDataType != BYTE_TYPE) {
            flush();
        }
        byteAccumulator += message;
        lastMessageDataType = BYTE_TYPE;
    }

    public static void log (char message) {
        lastMessageDataType = CHAR_TYPE;
        push(message);
    }

    public static void log (String message) {
        if (lastMessageDataType != STRING_TYPE || !message.equals(stringBuffer)) {
            flush();
        }
        stringBuffer = message;
        stringAccumulator++;
        lastMessageDataType = STRING_TYPE;
    }

    public static void log (Object message) {
        lastMessageDataType = OBJECT_TYPE;
        push(message);
    }

    public static void flush () {
        switch (lastMessageDataType) {
            case INT_TYPE:    push(intAccumulator);
                              intAccumulator = 0;
                              break;
            case BYTE_TYPE:   push(byteAccumulator);
                              byteAccumulator = 0;
                              break;
            case STRING_TYPE: push(stringAccumulator == 1 ? stringBuffer : String.format("%s (x%d)", stringBuffer, stringAccumulator));
                              stringAccumulator = 0;
                              break;
        }
    }

    private static <T> void push(T message) {
        print(decorate(message));
    }
}
