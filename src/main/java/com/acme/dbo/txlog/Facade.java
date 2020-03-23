package com.acme.dbo.txlog;

import static java.lang.Math.abs;

public class Facade {
    public static boolean isDecorated;
    private static Integer lastSum = 0;
    private static boolean isLastInteger = false;
    private static String INTEGER_DECOR = "primitive: ";
    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String BYTE_DECOR = PRIMITIVE_DECOR;
    private static String CHAR_DECOR = "char: ";
    private static String STRING_DECOR = "string: ";
    private static String REFERENCE_DECOR = "reference: ";



    public static void log(int message) {
        if (Facade.checkIntegerValueIsOutBound(message)) {
            writeLogWhenOutBound(String.valueOf(message),"Integer");
        } else {
            String msg = String.valueOf(message);
            if (Facade.isDecorated) {
                msg = String.valueOf(message);
                Facade.writeLog(Facade.INTEGER_DECOR, msg);
            } else {
                lastSum = lastSum + message;
                Facade.isLastInteger = true;
            }
        }
    }


    public static void log(boolean message) {
        String msg = String.valueOf(message);
        Facade.writeLog(Facade.PRIMITIVE_DECOR, msg);
        flushLastIntegerState();
    }

    public static void log(byte message) {
        if (Facade.checkByteValueIsOutBound(message)) {
            writeLogWhenOutBound(String.valueOf(message),"Byte");
        }
        else {
            String msg = String.valueOf(message);
            Facade.writeLog(Facade.BYTE_DECOR, msg);
            flushLastIntegerState();
        }
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

    private static void writeLogWhenOutBound (String message, String type){
        if (type.equals("Integer")) {
            String msg = String.valueOf(Integer.MAX_VALUE);
        }
        if (type.equals("Byte")) {
            String msg = String.valueOf(Byte.MAX_VALUE);
        }
        flush();
        Facade.writeLog(Facade.INTEGER_DECOR, message);
    }

    private static void writeOutput(Object msg) {
        System.out.println(msg);
    }

    private static void flushLastIntegerState() {
        Facade.lastSum = 0;
        Facade.isLastInteger = false;
    }

    private static boolean checkIntegerValueIsOutBound(Integer number) {
        long longValue = (long) number;
        if (abs(longValue) >= Integer.MAX_VALUE) {
            return true;
        } else return false;
    }

    private static boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        if (abs(shortValue) >= Byte.MAX_VALUE) {
            return true;
        } else return false;
    }

//    private static boolean checkValueIsOutBound(Object number, String type) {
//
//        switch (type) {
//            case ("Integer"):
//                long maxValue;
//                maxValue = Integer.MAX_VALUE;
//                long longValue = (long) number;
//                break;
//            case ("Byte"):
//                Integer longValue = (Integer) number;
//                maxValue = Byte.MAX_VALUE;
//                break;
//            default:
//                maxValue = Long.MAX_VALUE;
//                long longValue = (long) number;
//                break;
//        }
//        if (abs(longValue) >= maxValue) {
//            return true;
//        } else return false;
//    }
}
