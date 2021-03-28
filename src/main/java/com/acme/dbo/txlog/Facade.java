package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static Integer intMessagesAccumulated = null;
    private static String stringMesssagesAccumulated = null;
    private static Byte byteMessagesAccumulated = null;
    private static Integer duplicatedStringMessagesCounter = 0;
    private static boolean isMessageTypeChanged;

    public static void log(int message) {
        if (intMessagesAccumulated == null) {
            flush();
            intMessagesAccumulated = message;
        } else {
            intMessagesAccumulated += message;
        }
    }

    public static void log(char message) {
        flush();
        printMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        if (stringMesssagesAccumulated == null) {
            stringMesssagesAccumulated = message;
        } else {
            if (!stringMesssagesAccumulated.equals(message)) {
                flush();
                stringMesssagesAccumulated = message;
            }
        }
        duplicatedStringMessagesCounter++;
    }

    public static void log(byte message) {
        flush();
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(boolean message) {
        flush();
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        flush();
        printMessage(decorate(REFERENCE_PREFIX, message));
    }

    public static void flush() {
        if (ifIntCurrentState(intMessagesAccumulated)) {
            printMessage(decorate(PRIMITIVE_PREFIX, intMessagesAccumulated));

        }
        if (ifStringCurrentState(duplicatedStringMessagesCounter)) {
            if (duplicatedStringMessagesCounter == 1) {
                printMessage(decorate(STRING_PREFIX, stringMesssagesAccumulated));
            } else {
                printMessage(decorate(STRING_PREFIX, stringMesssagesAccumulated + " (x" + duplicatedStringMessagesCounter + ")"));
            }

        }
        intMessagesAccumulated = null;
        duplicatedStringMessagesCounter = 0;
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String decorate(String stringPrefix, Object message) {
        return stringPrefix + message;
    }

    private static boolean ifIntCurrentState(Integer intMessagesAccumulated) {
        return intMessagesAccumulated != null;
    }

    private static boolean ifStringCurrentState (Integer stringMessagesRepeatCounter) {
        return stringMessagesRepeatCounter !=0;
    }
}
