package com.acme.dbo.txlog;

public class Facade {

    public static final String PREFIX_PRIMITIVE = "primitive:";
    public static final String PREFIX_CHAR = "char:";
    public static final String PREFIX_REFERENCE = "reference:";

    private static Long lastIntValue = null;
    private static String overloadInt = null;
    private static Integer lastByteValue = null;
    private static String overloadByte = null;
    private static String lastStringValue = null;
    private static int equalsStringsCount = 0;

    public static void log(int message) {
        if (lastByteValue != null | lastStringValue != null) {
            flush();
        }

        if (lastIntValue == null) {
            lastIntValue = Integer.valueOf(message).longValue();
        } else {
            if (lastIntValue + message > Integer.MAX_VALUE) {
                if (overloadInt == null) {
                    overloadInt = decorate(PREFIX_PRIMITIVE, lastIntValue);
                } else {
                    overloadInt = System.lineSeparator() + decorate(PREFIX_PRIMITIVE, lastIntValue);
                }
                lastIntValue = (long) Integer.MAX_VALUE;
            } else {
                lastIntValue += message;
            }
        }
    }

    public static void log(byte message) {
        if (lastIntValue != null | lastStringValue != null) {
            flush();
        }

        if (lastByteValue == null) {
            lastByteValue = (int) message;
        } else {
            if (lastByteValue + message > Byte.MAX_VALUE) {
                if (overloadByte == null) {
                    overloadByte = decorate(PREFIX_PRIMITIVE, lastByteValue);
                } else {
                    overloadByte = System.lineSeparator() + decorate(PREFIX_PRIMITIVE, lastByteValue);
                }
                lastByteValue = (int) Byte.MAX_VALUE;
            } else {
                lastByteValue += message;
            }
        }
    }

    public static void log(boolean message) {
        if (lastIntValue != null | lastByteValue != null | lastStringValue != null) {
            flush();
        }

        logInternal(decorate(PREFIX_PRIMITIVE, message));
    }

    public static void log(char message) {
        if (lastIntValue != null | lastByteValue != null | lastStringValue != null) {
            flush();
        }

        logInternal(decorate(PREFIX_CHAR, message));
    }

    public static void log(String message) {
        if (lastIntValue != null | lastByteValue != null) {
            flush();
        }

        if (lastStringValue != null) {
            if (lastStringValue.equals(message)) {
                equalsStringsCount++;
            } else {
                flush();
                lastStringValue = message;
                equalsStringsCount = 1;
            }
        } else {
            lastStringValue = message;
            equalsStringsCount = 1;
        }
    }

    public static void log(Object message) {
        if (lastIntValue != null | lastByteValue != null | lastStringValue != null) {
            flush();
        }

        logInternal(decorate(PREFIX_REFERENCE, message));
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
            }
            logInternal(decorate(PREFIX_PRIMITIVE, lastIntValue));
        } else if (lastByteValue != null) {
            if (overloadByte != null) {
                logInternal(overloadByte);
            }
            logInternal(decorate(PREFIX_PRIMITIVE, lastByteValue));
        } else if (lastStringValue != null) {
            String msg = lastStringValue;
            if (equalsStringsCount > 1) {
                msg += " (x" + equalsStringsCount + ")";
            }
            logInternal(decorate("string:", msg));
        }

        resetState();
    }

    private static void resetState() {
        lastIntValue = null;
        overloadInt = null;
        lastByteValue = null;
        overloadByte = null;
        lastStringValue = null;
        equalsStringsCount = 0;
    }
}
