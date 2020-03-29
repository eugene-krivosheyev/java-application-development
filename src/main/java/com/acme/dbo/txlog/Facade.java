package com.acme.dbo.txlog;


public class Facade {

    private static String stringAccum;
    private static int sequenceCounter = 0;

    private static int intAccum;
    private static boolean intSequenceStart = false;

    private static byte byteAccum;
    private static boolean byteSequenceStart = false;

    public static void log(int message, boolean decorator) {
        if (decorator) {log(message);}
        else {
            if (!intSequenceStart) {
                clearStringAccum();
                clearByteAccum();
                intAccum = message;
                intSequenceStart = true;
            }
            else if (intSequenceStart) {
                try {
                    intAccum = Math.addExact(intAccum, message);
                }
                catch(ArithmeticException e) {
                    clearIntAccum();
                    log(message, false);
                }
            }
        }
    }

    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message, boolean decorator) {
        if (decorator) {log(message);}
        else {
            if (!byteSequenceStart) {
                clearStringAccum();
                clearIntAccum();
                byteAccum = message;
                byteSequenceStart = true;
            }
            else if (byteSequenceStart) {
                if (byteAccum + message > Byte.MAX_VALUE) {
                    clearByteAccum();
                    log(message, false);
                }
                else {byteAccum += message;}
            }
        }
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message, boolean decorator) {
        if (decorator) {log(message);}
        else {
            if (stringAccum == null) {
                clearIntAccum();
                clearByteAccum();
                stringAccum = message;
                sequenceCounter++;
            }
            else if (stringAccum.equals(message)) {
                sequenceCounter++;
            }
            else if (!stringAccum.equals(message) && sequenceCounter > 0) {
                clearStringAccum(message);
            }
        }
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }

    public static void clear() {
        clearStringAccum();
        clearIntAccum();
        clearByteAccum();
    }

    private static void clearStringAccum(String message) {
        String postfix = "";
        if (sequenceCounter > 1) {postfix = " (x" + sequenceCounter + ")";}
        System.out.println(stringAccum + postfix);
        sequenceCounter = 1;
        stringAccum = message;
    }

    private static void clearStringAccum() {
        if (stringAccum != null) {
            String postfix = "";
            if (sequenceCounter > 1) {postfix = " (x" + sequenceCounter + ")";}
            System.out.println(stringAccum + postfix);
        }
        sequenceCounter = 0;
        stringAccum = null;
    }

    private static void clearIntAccum() {
        if (intSequenceStart) {System.out.println(intAccum);}
        intAccum = 0;
        intSequenceStart = false;
    }

    private static void clearByteAccum() {
        if (byteSequenceStart) {System.out.println(byteAccum);}
        byteAccum = 0;
        byteSequenceStart = false;
    }

}
