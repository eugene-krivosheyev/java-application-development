package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static int intAccum;
    public static String messageType;
    private static byte byteAccum;
    private static int stringAccum;
    private static String lastStringMessage;

    public static void log(int message) {
        if (messageType == null) {
            assignValues(message);
        } else if (messageType != "int") {
            flush(messageType);
            assignValues(message);
        } else {
            if (message == Integer.MAX_VALUE) {
                flush(messageType);
                System.out.println(PRIMITIVE + message);
            } else if (Integer.MAX_VALUE - intAccum - message < 0) {
                flush(messageType);
                intAccum = message;
            } else {
                intAccum += message;
            }
        }
    }

    public static void log(byte message) {
        if (messageType == null) {
            assignValues(message);
        } else if (messageType != "byte") {
            flush(messageType);
            assignValues(message);
        } else {
            if (message == Byte.MAX_VALUE) {
                flush(messageType);
                System.out.println(PRIMITIVE + message);
            } else if (Byte.MAX_VALUE - byteAccum - message < 0) {
                flush(messageType);
                byteAccum = message;
            } else {
                byteAccum += message;
            }
        }
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }

    public static void log(String message) {
        if (messageType == null) {
            assignValues(message);
        } else if (messageType != "String") {
            flush(messageType);
            assignValues(message);
        } else {
            if (lastStringMessage.equals(message)) {
                stringAccum += 1;
            } else {
                flush(messageType);
                assignValues(message);
            }
        }
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
                if (stringAccum == 1) {
                    System.out.println(STRING + lastStringMessage);
                    stringAccum = 0;
                } else if (stringAccum > 1) {
                    System.out.println(STRING + lastStringMessage + " (x" + stringAccum + ")");
                    stringAccum = 0;
                }
                break;
            case "byte":
                System.out.println(PRIMITIVE + byteAccum);
                byteAccum = 0;
                break;
        }
        return Facade.messageType = null;
    }

    public static void clear() {
        flush(messageType);
        messageType = null;
    }

    private static void assignValues(int message) {
        messageType = "int";
        intAccum = message;
    }

    private static void assignValues(byte message) {
        messageType = "byte";
        byteAccum = message;
    }

    private static void assignValues(String message) {
        messageType = "String";
        stringAccum = 1;
        lastStringMessage = message;
    }
}
