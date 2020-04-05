package com.acme.dbo.txlog;

import java.util.Arrays;

public class Facade {

    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static final String PRIMITIVEARRAY = "primitives array: ";
    public static final String PRIMITIVESMATRIX = "primitives matrix: ";
    public static final String PRIMITIVESMULTIMATRIX = "primitives multimatrix: ";

    public static final byte TYPENOTDEFINED = 0;
    public static final byte TYPEBYTE = 1;
    public static final byte TYPEINT = 2;
    public static final byte TYPECHAR = 3;
    public static final byte TYPESTRING = 4;
    public static final byte TYPEBOOLEAN = 5;
    public static final byte TYPEOBJECT = 6;
    public static byte currentType = TYPENOTDEFINED;

    public static int intSum = 0;
    public static byte byteSum = 0;
    public static String stringSum = null;
    public static int stringCount = 0;

    public static void log(int message) {
        if (currentType != TYPEINT) {
            flush(currentType);
            currentType = TYPEINT;
        }
        long checkOverflow = (long) intSum + (long) message;
        if (checkOverflow > Integer.MAX_VALUE) {
            flush(currentType);
        }
        intSum += message;
    }

    public static void log(byte message) {
        if (currentType != TYPEBYTE) {
            flush(currentType);
            currentType = TYPEBYTE;
        }
        short checkOverflow = (short) (byteSum + message);

        if (checkOverflow > Byte.MAX_VALUE) {
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

    public static void log (int[] message) {
        System.out.print(PRIMITIVEARRAY + '{');
        for(int i = 0; i < message.length; i++) {
            System.out.print(message[i]);
            if(i < (message.length - 1))
                System.out.print(", ");
        }
        System.out.println('}');
    }

    public static void log (int value, int... message) {
        int Sum = value;
        boolean overflowDetected = false;
        for(int i : message) {
            if((Sum >= Integer.MAX_VALUE) | (long) (Sum + i) >= (long) Integer.MAX_VALUE)  {
                overflowDetected = true;
                System.out.print(Integer.toString(Sum));
                Sum = i;
            }
            else{
                Sum = +i;
            }
        }
        if (overflowDetected & Sum > 0) {
            System.out.print(" + ");
            System.out.println(Integer.toString(Sum));
        }
        else if (overflowDetected & Sum < 0) {
            System.out.print(" - ");
            System.out.println(Integer.toString(Math.abs(Sum)));
        }
        else {
            System.out.println(Integer.toString(Sum));
        }
    }

    public static void log (int[][] message) {
        System.out.println(PRIMITIVESMATRIX + "{");
        for(int i = 0; i < message.length; i++) {
            System.out.print('{');
            for(int j = 0; j < message[i].length; j++) {
                System.out.print(message[i][j]);
                if (j < (message[i].length - 1))
                    System.out.print(", ");
                else
                    System.out.println('}');
            }
        }
        System.out.println('}');
    }

    public static void log (int[][][][] message) {
        System.out.print(PRIMITIVESMULTIMATRIX);
        String array = Arrays.deepToString(message);
        String array1 = array.replace("[[","{\r\n{\r\n");
        String array2 = array1.replace("[","{\r\n");
        String array3 = array2.replace("]]","\r\n}\r\n}");
        String array4 = array3.replace("]","}\r\n");
        System.out.println(array4);
    }

    public static void log (String... message) {
        for(String current : message) {
            System.out.println(current);
        }
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
