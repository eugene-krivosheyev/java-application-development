package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static final byte TYPENOTDEFINED = 0;
    public static final byte TYPEBYTE = 1;
    public static final byte TYPEINT = 2;
    public static final byte TYPECHAR = 3;
    public static final byte TYPESTRING = 4;
    public static final byte TYPEBOOLEAN = 5;
    public static final byte TYPEOBJECT = 6;

    public static byte currentType = TYPENOTDEFINED;
    public static int intSum = 0;
    public static int byteSum = 0;
    public static String stringSum = null;
    public static int stringCount = 0;

    public static void log(int message) {
        if (currentType != TYPEINT) {
            flush(currentType);
            currentType = TYPEINT;
        }
        if ((Integer.MAX_VALUE - intSum) < message) {

            flush(currentType);
        }
        intSum += message;
    }

    public static void log(byte message) {
        if (currentType != TYPEBYTE) {
            flush(currentType);
            currentType = TYPEBYTE;
        }
        if ((Byte.MAX_VALUE - byteSum) < message ) {
            flush(currentType);
        }
        byteSum += message;
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }

    public static void log(String message) {
        if(message == "" && currentType != TYPENOTDEFINED) {
            flush(currentType);
        }
        else if (currentType != TYPESTRING && currentType != TYPENOTDEFINED) {
            flush(currentType);
            currentType = TYPESTRING;
            stringSum = message;
            stringCount++;
        }
        else if (currentType == TYPENOTDEFINED) {
            currentType = TYPESTRING;
            stringSum = message;
            stringCount++;
        }
        else {
            if (stringSum != message)
            flush(currentType);
            stringSum = message;
            stringCount++;
        }
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE + message);
    }


    public static void flush (byte currentType) {
        switch (currentType) {
            case TYPENOTDEFINED:
                break;
            case TYPEINT:
                System.out.println(PRIMITIVE + intSum);
                intSum = 0;
                break;
            case TYPESTRING:
                if (stringCount > 1) {
                    System.out.println(STRING + stringSum + " (x" + stringCount + ')');
                }
                else {
                    System.out.println(STRING + stringSum);
                }
                stringSum = null;
                stringCount = 0;
                break;
            case TYPEBYTE:
                System.out.println(PRIMITIVE + byteSum);
                byteSum = 0;
                break;
        }
    }
}
