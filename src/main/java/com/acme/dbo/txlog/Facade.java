package com.acme.dbo.txlog;

import java.net.StandardSocketOptions;

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
    private static String aggregatedOneDimArray = "";
    private static String aggregatedTwoDimArray = "";

    static TypeChangeController typeChangeController = new TypeChangeController();
    static ThresholdChecker thresholdChecker = new ThresholdChecker();
    static ArrayDecorator messageDecorator = new ArrayDecorator();


    public static void log(int[][] message) {
        currentState = "INT[][]";
        if (typeChangeController.checkIfStateSwithched(currentState,previousState)) {
            flush();
        }
        aggregatedTwoDimArray = messageDecorator.arrayDecorate(message);
        previousState = currentState;
    }

    public static void log(int[] message) {
        currentState = "INT[]";
        if (typeChangeController.checkIfStateSwithched(currentState,previousState)) {
            flush();
        }
        aggregatedOneDimArray = messageDecorator.arrayDecorate(message);
        previousState = currentState;
    }


    public static void log(int message) {
        currentState = "INT";  //SetCurrentState based on msg input;
        if (typeChangeController.checkIfStateSwithched(currentState,previousState) || thresholdChecker.checkIfThresholdExceeded(aggregatedInt,message)) {
             flush();
             aggregatedInt = message; // flush and start new aggregation;
        }
        else {
            aggregatedInt = aggregatedInt + message; //continue aggregation no flush;
        }
        previousState = currentState;
    }

    public static void log(byte message) {
        currentState = "BYTE";
        if (typeChangeController.checkIfStateSwithched(currentState,previousState) || thresholdChecker.checkIfThresholdExceeded(aggregatedByte,message)) {
            flush();
            aggregatedByte = message; // flush and start new aggregation;
        }
        else {
            aggregatedByte = aggregatedByte + message; //continue aggregation no flush;
        }
        previousState = currentState;
    }

    public static void log(String message) {
        currentState = "STR";
        if (previousState.equals("STR") || previousState.equals("NAN")) {
            if (aggregatedString.equals(message)) {
                stringAppearanceCounter++;
               } else flush();
            aggregatedString = message;
          } else {
             aggregatedString = message;
            flush();
        }
        previousState = currentState;
    }

    public static void log(char message) {
        print(decorateMessage(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(Boolean message) {
        print(decorateMessage(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        print(decorateMessage(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String decorateMessage(String prefix, Object message, String postfix) {
        message = prefix + message + postfix;
        return message.toString();
    }

    public static void flush() {
        if (previousState == "STR") {
            if (stringAppearanceCounter > 1) {
                aggregatedString = aggregatedString + " (x" + stringAppearanceCounter + ")";
                stringAppearanceCounter = 1;
            }
            print(decorateMessage(STRING_PREFIX, aggregatedString, STRING_POSTFIX));
            aggregatedString = "";
        } else if (previousState == "INT") {
            print(decorateMessage(PRIMITIVE_PREFIX, aggregatedInt, PRIMITIVE_POSTFIX));
            aggregatedInt = 0;
        } else if (previousState == "BYTE") {
            print(decorateMessage(PRIMITIVE_PREFIX, aggregatedByte, PRIMITIVE_POSTFIX));
            aggregatedByte = 0;
        } else if (previousState == "INT[]") {
            print(decorateMessage(PRIMITIVE_ARRAY_PREFIX, aggregatedOneDimArray, PRIMITIVE_ARRAY_POSTFIX));
            aggregatedOneDimArray = "";
        } else if (previousState == "INT[][]") {
            print(decorateMessage(PRIMITIVE_MATRIX_PREFIX, aggregatedTwoDimArray, PRIMITIVE_MATRIX_POSTFIX));
            aggregatedTwoDimArray = "";
        } else {
        }
    }

}
