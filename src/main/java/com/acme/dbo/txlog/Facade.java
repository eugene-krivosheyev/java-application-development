package com.acme.dbo.txlog;

public class Facade {

    private static Long lastIntValue = null;
    private static String overloadInt = null;
    private static Integer lastByteValue = null;
    private static String overloadByte = null;
    private static String lastStringValue = null;
    private static int equalsStringsCount = 0;

    public static void log(int message) {
        if (lastIntValue == null) {
            lastIntValue = Integer.valueOf(message).longValue();
        } else {
            if (lastIntValue + message > Integer.MAX_VALUE) {
                if (overloadInt == null) {
                    overloadInt = "primitive: " + lastIntValue;
                } else {
                    overloadInt = System.lineSeparator() + "primitive: " + lastIntValue;
                }
            } else {
                lastIntValue += message;
            }
        }
    }

    public static void log(byte message) {
        if (lastByteValue == null) {
            lastByteValue = (int) message;
        } else {
            lastByteValue += message;
        }
    }

    public static void log(boolean message) {
        logInternal(decorate("primitive:", message));
    }

    public static void log(char message) {
        logInternal(decorate("char:", message));
    }

    public static void log(String message) {
        if (lastStringValue != null && lastStringValue.equals(message)) {
            equalsStringsCount++;
        } else if (lastStringValue == null) {
            lastStringValue = message;
            equalsStringsCount = 1;
        }
    }

    public static void log(Object message) {
        logInternal(decorate("reference:", message));
    }

    public static String decorate(String prefix, Object message) {
        return prefix + " " + message;
    }

    public static void logInternal(String message) {
        System.out.println(message);
    }

    public static void flush() {
        if (lastIntValue != null) {
            if (overloadInt != null) {
                logInternal(overloadInt);
                logInternal(decorate("primitive:", lastIntValue));
            } else {
                logInternal(decorate("primitive:", lastIntValue));
            }
        } else if (lastByteValue != null) {
            logInternal(decorate("primitive:", lastByteValue));
        } else if (lastStringValue != null) {
            String msg = lastStringValue;
            if (equalsStringsCount > 1) {
                msg += " (x" + equalsStringsCount + ")";
            }
            logInternal(decorate("string:", msg));
        }

        lastIntValue = null;
        overloadInt = null;
        lastByteValue = null;
        overloadByte = null;
        lastStringValue = null;
        equalsStringsCount = 0;
    }
}
