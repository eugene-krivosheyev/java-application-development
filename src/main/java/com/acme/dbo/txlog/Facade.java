package com.acme.dbo.txlog;

public class Facade {
    public static boolean isDecorated;
    private static Integer lastSum = 0;
    private static boolean isLastInteger;
    private static String INTEGER_DECOR = "primitive: ";
    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String CHAR_DECOR = "char: ";
    private static String STRING_DECOR = "string: ";
    private static String REFERENCE_DECOR = "reference: ";

//    public static Integer numberOfSeqDuplStrings=0;
//    public static String lastString;


    public static void log(int message) {
        if (Facade.isDecorated) {
            String msg = String.valueOf(message);
            Facade.writeLog(Facade.INTEGER_DECOR, msg);
        } else {
            lastSum = lastSum + message;
            Facade.isLastInteger = true;
        }
    }

    public static void log(boolean message) {
        String msg = String.valueOf(message);
        Facade.writeLog(Facade.PRIMITIVE_DECOR, msg);
        flushLastIntegerState();
    }

    public static void log(byte message) {
        String msg = String.valueOf(message);
        Facade.writeLog(Facade.PRIMITIVE_DECOR, msg);
        flushLastIntegerState();
    }

    public static void log(char message) {
        String msg = String.valueOf(message);
        Facade.writeLog(CHAR_DECOR, msg);
        flushLastIntegerState();
    }

    public static void log(String message) {
        String msg = String.valueOf(message);
        Facade.writeLog(STRING_DECOR, msg);
        flushLastIntegerState();
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_DECOR + message);
        flushLastIntegerState();
    }

    public static void flush() {
        String msg = String.valueOf(Facade.lastSum);
        Facade.writeFlushedLog(INTEGER_DECOR);

        flushLastIntegerState();
    }

    private static void writeLog(String decoration, String message) {
        if (Facade.isLastInteger) {
            Facade.writeFormattedLog(decoration, Facade.lastSum);
        }
        Facade.writeFormattedLog(decoration, message);
    }

    private static void writeFormattedLog(String decoration, Object message) {
        if (Facade.isDecorated) {
            Facade.writeOutput(decoration + message);
        } else {
            Facade.writeOutput(message);
        }
    }

    private static void writeFlushedLog(String decoration) {
        if (Facade.isLastInteger) {
            writeFormattedFlushedLog(decoration, Facade.lastSum);
        }
    }

    private static void writeFormattedFlushedLog(String decoration, Object message) {
        if (Facade.isDecorated) {
            Facade.writeOutput(decoration + message);
        } else {
            Facade.writeOutput(message);
        }
    }

    private static void writeOutput(Object msg) {
        System.out.println(msg);
    }

    private static void flushLastIntegerState() {
        Facade.lastSum = 0;
        Facade.isLastInteger = false;
    }
}
