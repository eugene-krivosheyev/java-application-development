/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;


public class Facade {
    public static final String OBJECT_PREFIX = "reference: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String CHAR_POSTFIX = "";
    private static final String OBJECT_POSTFIX = "";
    private static final String STRING_POSTFIX = "";

    public static boolean intSequence = false;
    public static int intAccumulator = 0;

    public static boolean byteSequence = false;
    public static byte byteAccumulator = 0;

    public static boolean stringSequence = false;
    public static String lastString = null;
    public static int stringCounter = 0;

    public static void log(char message) {
        flush();
        printMessage(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(int message) {
        if (intSequence) {
            if ((long) intAccumulator + message > Integer.MAX_VALUE) {
                flush();
                intSequence = true;
            }
            intAccumulator += message;
        } else {
            flush();
            intAccumulator = message;
        }
        intSequence = true;
    }

    public static void log(boolean message) {
        flush();
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(byte message) {
        if (byteSequence) {
            if (byteAccumulator + message > Byte.MAX_VALUE) {
                flush();
                byteSequence = true;
            }
            byteAccumulator += message;
        } else {
            flush();
            byteAccumulator = message;
        }
        byteSequence = true;
    }

    public static void log(String message) {
        if (stringSequence) {
            if (message.equals(lastString)) {
                stringCounter++;
            } else {
                processStringAsFirstInSequence(message);
            }
        } else {
            processStringAsFirstInSequence(message);
        }
        stringSequence = true;
    }

    public static void log(Object message) {
        flush();
        printMessage(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    public static void flush() {
        if (intSequence) {
            printMessage(decorate(PRIMITIVE_PREFIX, intAccumulator, PRIMITIVE_POSTFIX));
            intSequence = false;
            intAccumulator = 0;
        } else if (byteSequence) {
            printMessage(decorate(PRIMITIVE_PREFIX, byteAccumulator, PRIMITIVE_POSTFIX));
            byteSequence = false;
            byteAccumulator = 0;
        } else if (stringSequence) {
            printMessage(decorate(STRING_PREFIX, getStringDependingOnCounter(lastString, stringCounter), STRING_POSTFIX));
            stringSequence = false;
            lastString = null;
            stringCounter = 0;
        }
    }

    private static String decorate(String stringPrefix, Object message, String stringPostfix) {
        return stringPrefix + message + stringPostfix;
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }

    private static void processStringAsFirstInSequence(String message) {
        flush();
        stringCounter = 1;
        lastString = message;
    }

    private static String getStringDependingOnCounter(String message, int stringCounter) {
        if (stringCounter == 1) {
            return message;
        } else {
            return message + " (x" + stringCounter + ")";
        }
    }
}
