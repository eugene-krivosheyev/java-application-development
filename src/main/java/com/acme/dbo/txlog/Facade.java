package com.acme.dbo.txlog;

import java.util.concurrent.ExecutionException;

public class Facade {
    private static String PREVIOUS_TYPE = new String("first");
    private static String PREFIX = null;
    private static Object VALUE = null;
    private static int STRING_COUNTER = 0;

    private static void print() {
        if (VALUE != null) {
            if (STRING_COUNTER > 1)
                VALUE = VALUE.toString() + " (x" + STRING_COUNTER + ")";
            System.out.println(PREFIX + ": " + VALUE);
            VALUE = null;
            PREFIX = null;
            STRING_COUNTER = 0;
        }
    }

    private static boolean tryToPrintThePreviousValue(String currentType) {
        if (currentType.equals(PREVIOUS_TYPE))
            return false;
        print();
        PREVIOUS_TYPE = currentType;
        return true;
    }


    public static void log(int message) {
        if (!tryToPrintThePreviousValue("int"))
            if (Integer.MAX_VALUE - message > (Integer) VALUE)
                VALUE = (Integer) VALUE + message;
            else {
                print();
                VALUE = message;
                PREFIX = "primitive";
            }
        else {
            VALUE = message;
            PREFIX = "primitive";
        }
    }

    public static void log(char message) {
        if (!tryToPrintThePreviousValue("char"))
            print();
        VALUE = message;
        PREFIX = "char";
    }

    public static void log(String message) {
        if (!tryToPrintThePreviousValue("string") && !message.equals(VALUE))
            print();
        VALUE = message;
        PREFIX = "string";
        STRING_COUNTER++;
    }

    public static void log(boolean message) {
        if (!tryToPrintThePreviousValue("boolean"))
            print();
        VALUE = message;
        PREFIX = "primitive";
    }

    public static void log(Object message) {
        if (!tryToPrintThePreviousValue("Object"))
            print();
        VALUE = message;
        PREFIX = "reference";
    }

    public static void log(byte message) {
        if (!tryToPrintThePreviousValue("byte"))
            if (Byte.MAX_VALUE - message > (Byte) VALUE)
                VALUE = (Byte) VALUE + message;
            else {
                print();
                VALUE = message;
                PREFIX = "primitive";
            }
        else {
            VALUE = message;
            PREFIX = "primitive";
        }
    }

    public static void stop() {
        print();
        PREVIOUS_TYPE = "stop";
    }
}
