package com.acme.dbo.txlog;

import static java.lang.System.lineSeparator;

public class Facade {


    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    private static final String OBJECT_PREFIX = "reference: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String OBJECT_POSTFIX = "";
    private static final String CHAR_POSTFIX = "";
    private static final String PRIMITIVE_ARRAY_POSTFIX = "";
    private static final String PRIMITIVE_MATRIX_POSTFIX = "";

    private static String previousState = "NAN";
    private static String currentState = "NAN";
    private static String aggregatedString = "";
    private static int stringAppearanceCounter = 1;
    private static int aggregatedInt;
    private static int aggregatedByte;
    private static StringBuilder aggregatedOneDimArray = new StringBuilder("");
    private static StringBuilder aggregatedMultyDimArray = new StringBuilder("");
    private static StringBuilder partMultyDimArray = new StringBuilder("");


    public static void log(int[][] message) {
        currentState = "INT[][]";
        if (previousState.equals("INT[]") || previousState.equals("NAN") || previousState.equals("INT[][]")) {
            //    System.out.println("INT[][] arrived:" + message);
            aggregatedMultyDimArray.append("{" + lineSeparator());
            for (int[] onedimArray : message) {
            // log(onedimArray); //Has side effects!
            //   currentState = "INT[][]"; // SETS STATE TOO, side effect! REMOVING SIDE EFFECT 1
            //   aggregatedMultyDimArray.append(aggregatedOneDimArray).append(lineSeparator());
            //    aggregatedOneDimArray = aggregatedOneDimArray.delete(0, aggregatedOneDimArray.length()); //REMOVING SIDE EFFECT 2
                partMultyDimArray.append("{");
                for (int elem : onedimArray) {
                    partMultyDimArray.append(elem).append(", ");
                }
                partMultyDimArray.deleteCharAt(partMultyDimArray.length() - 1).deleteCharAt(partMultyDimArray.length() - 1);
                partMultyDimArray.append("}");
                aggregatedMultyDimArray.append(partMultyDimArray).append(lineSeparator());
                partMultyDimArray = partMultyDimArray.delete(0, partMultyDimArray.length());
            }
            aggregatedMultyDimArray.append("}");
        }
        //TODO else create aggregatedMultyDimArray the same way as in if (constructMessageOutOfArray(arr[][]), FLUSH
        previousState = currentState;
    }

    public static void log(int[] message) {
        currentState = "INT[]";
        if (previousState.equals("INT[]") || previousState.equals("NAN") || previousState.equals("INT[][]")) {
            //    System.out.println("INT[] arrived:" + message);
            aggregatedOneDimArray.append("{");
            for (int elem : message) {
                aggregatedOneDimArray.append(elem).append(", ");
            }
            aggregatedOneDimArray.deleteCharAt(aggregatedOneDimArray.length() - 1).deleteCharAt(aggregatedOneDimArray.length() - 1);
            aggregatedOneDimArray.append("}");
        }
        //TODO else create aggregatedMultyDimArray the same way as in if (constructMessageOutOfArray(arr[]), FLUSH
        previousState = currentState;
    }

    //TODO Refactor!
    public static void log(int message) {
        currentState = "INT";
        //    System.out.println("INT arrived:" + message);
        if (previousState.equals("INT") || previousState.equals("NAN")) {
            if (Integer.MAX_VALUE - message > aggregatedInt) {
                aggregatedInt = aggregatedInt + message;
                //          System.out.println("#0 " + previousState + "->" + currentState + " " + aggregatedInt + " /#0");
            } else {
                flush();
                aggregatedInt = message;
                //          System.out.println("#1 " + previousState + "->" + currentState + " " + aggregatedInt + " /#1");
            }
        } else {
            aggregatedInt = aggregatedInt + message;
            //      System.out.println("#2 " + previousState + "->" + currentState + " " + aggregatedInt + " /#2");
            flush();
        }
        previousState = currentState;
    }

    public static void log(byte message) {
        currentState = "BYTE";
        //    System.out.println("BYTE arrived:" + message);
        if (previousState.equals("BYTE") || previousState.equals("NAN")) {
            if (Byte.MAX_VALUE - message > aggregatedByte) {
                aggregatedByte = aggregatedByte + message;
                //        System.out.println("#3 " + previousState + "->" + currentState + " " + aggregatedByte + " /#3");
            } else {
                flush();
                aggregatedByte = message;
                //        System.out.println("#4 " + previousState + "->" + currentState + " " + aggregatedByte + " /#4");
            }
        } else {
            aggregatedByte = aggregatedByte + message;
            //    System.out.println("#5 " + previousState + "->" + currentState + " " + aggregatedByte + " /#5");
            flush();
        }
        previousState = currentState;
    }

    public static void log(String message) {
        currentState = "STR";
        //    System.out.println("STR arrived:" + message);
        if (previousState.equals("STR") || previousState.equals("NAN")) {
            if (aggregatedString.equals(message)) {
                stringAppearanceCounter++;
                //      System.out.println("#6 " + previousState + "->" + currentState + " " + aggregatedString + " " + stringAppearanceCounter + " /#6");
            } else flush();
            aggregatedString = message;
            //    System.out.println("#7 " + previousState + "->" + currentState + " " + aggregatedString + " " + stringAppearanceCounter + " /#7");
        } else {
            //    System.out.println("#8 " + previousState + "->" + currentState + " " + aggregatedString + " " + stringAppearanceCounter + " /#8");
            aggregatedString = message;
            flush();
        }
        previousState = currentState;
    }

    public static void log(char message) {
        print(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(Boolean message) {
        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        print(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        message = prefix + message + postfix;
        return message.toString();
    }

    public static void flush() {
        if (previousState == "STR") {
            //    System.out.println("#90 " + aggregatedString);
            if (stringAppearanceCounter > 1) {
                aggregatedString = aggregatedString + " (x" + stringAppearanceCounter + ")";
                stringAppearanceCounter = 1;
            }
            print(decorate(STRING_PREFIX, aggregatedString, STRING_POSTFIX)); //normalize
            aggregatedString = "";
        } else if (previousState == "INT") {
            //    System.out.println("#91 " + aggregatedInt);
            print(decorate(PRIMITIVE_PREFIX, aggregatedInt, PRIMITIVE_POSTFIX));
            aggregatedInt = 0;
        } else if (previousState == "BYTE") {
            //    System.out.println("#92 " + aggregatedByte);
            print(decorate(PRIMITIVE_PREFIX, aggregatedByte, PRIMITIVE_POSTFIX));
            aggregatedByte = 0;
        } else if (previousState == "INT[]") {
            //    System.out.println("#93 " + aggregatedInt[]);
            print(decorate(PRIMITIVE_ARRAY_PREFIX, aggregatedOneDimArray, PRIMITIVE_ARRAY_POSTFIX));
            aggregatedOneDimArray = aggregatedOneDimArray.delete(0, aggregatedOneDimArray.length());
        } else if (previousState == "INT[][]") {
            //    System.out.println("#93 " + aggregatedInt[]);
            print(decorate(PRIMITIVE_MATRIX_PREFIX, aggregatedMultyDimArray, PRIMITIVE_MATRIX_POSTFIX));
            aggregatedMultyDimArray = aggregatedMultyDimArray.delete(0, aggregatedMultyDimArray.length());
            partMultyDimArray = partMultyDimArray.delete(0, partMultyDimArray.length());
        } else {
        }
    }

}
