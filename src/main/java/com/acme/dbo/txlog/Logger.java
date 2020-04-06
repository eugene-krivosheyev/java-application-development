package com.acme.dbo.txlog;

import java.util.Objects;

public class Logger {
    private static int intSum = 0;
    private static byte byteSum = 0;
    private static int stringCount = 0;
    private static String lastString;

    public static void flush() {
        clearIntCount();
        clearByteCount();
        clearLastString();
    }

    public static void logOtherTypeMessage(Message message) {
        writeMessage(message);
        flush();
    }

    public static void logIntMessage(Message message) {
        try {
            intSum = Math.addExact(intSum, message.getIntValue());
        } catch (ArithmeticException e) {
            writeMessage(message);
            intSum = message.getIntValue();
        } finally {
            writeMessage(new Message(intSum));
        }
        clearByMessageType(message);
    }


    public static void logByteMessage(Message message) {
        if ((int) message.getByteValue() + byteSum >= Byte.MAX_VALUE) {
            byteSum = message.getByteValue();
            writeMessage(message);
        } else {
            byteSum += message.getByteValue();
        }
        writeMessage(new Message(byteSum));
        clearByMessageType(message);
    }

    public static void logStringArrayMessage(String[] messages) {
        for (String message : messages) {
            logStringMessage(new Message(message));
        }
    }

    public static void logStringMessage(Message message) {
        if (Objects.equals(message.getValue(), lastString)) {
            stringCount++;
        } else {
            stringCount = 0;
            flush();
        }
        writeStringMessage(message);
        lastString = message.getValue();
        clearByMessageType(message);
    }

    private static void writeMessage(Message message) {
        System.out.println(Decorator.decorateMessage(message) + message.getValue());
    }

    private static void writeStringMessage(Message message) {
        if (stringCount == 0) {
            writeMessage(message);
        } else {
            System.out.println(Decorator.decorateMessage(message) + message.getValue() + " (x" + (stringCount + 1) + ")");
        }
    }

    private static void clearByMessageType(Message message) {
        switch (message.getMessageType()) {
            case INT: {
                clearByteCount();
                clearLastString();
                break;
            }
            case BYTE: {
                clearIntCount();
                clearLastString();
                break;
            }
            case STRING: {
                clearIntCount();
                clearByteCount();
                break;
            }
            default: {
                flush();
            }
        }
    }

    private static void clearIntCount() {
        intSum = 0;
    }

    private static void clearByteCount() {
        byteSum = 0;
    }

    private static void clearLastString() {
        lastString = null;
        stringCount = 0;
    }
}
