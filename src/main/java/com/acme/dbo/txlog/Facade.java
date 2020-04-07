package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static int intAccum;
    public static String messageType;

    public static void log(int message) {
        if (messageType == null && intAccum == 0) {
            messageType = "int";
            intAccum = message;
        } else if (messageType != "int") {
            flush(messageType);
            messageType = "int";
            intAccum = message;
        } else {
            if ((intAccum + message)<Integer.MAX_VALUE) {
                intAccum += message;
            }else{
                flush(messageType);
                intAccum = Integer.MAX_VALUE;
                System.out.println(PRIMITIVE + intAccum);
            }
        }
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }

    public static void log(String message) {
        if (messageType == null) {
            messageType = "String";
        } else if (messageType != "String") {
            flush(messageType);
            messageType = "String";
        }
        System.out.println(STRING + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE + message);
    }

    public static String flush(String messageType) {
        switch (messageType) {
            case "int":
                System.out.println(PRIMITIVE + intAccum);
                intAccum = 0;
                break;
            case "String":
                break;
        }
        return Facade.messageType = null;
    }
//
//    public static void clearTypeAndAccum() {
//        messageType = null;
//        intAccum = 0;
//    }
}
