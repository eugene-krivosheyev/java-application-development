package com.acme.dbo.txlog;

public class Facade {
    private static String PreviousType = "first";
    private static String Prefix;
    private static Object Value;
    private static int StringCounter;

    public static void log(int message) {
        if (tryToPrintThePreviousValue("int"))
            if (Integer.MAX_VALUE - message > (Integer) Value)
                Value = (Integer) Value + message;
            else {
                print();
                Value = message;
                Prefix = "primitive";
            }
        else {
            Value = message;
            Prefix = "primitive";
        }
    }

    public static void log(char message) {
        if (tryToPrintThePreviousValue("char")) print();
        Value = message;
        Prefix = "char";
    }

    public static void log(String message) {
        if (tryToPrintThePreviousValue("string") && !message.equals(Value)) print();
        Value = message;
        Prefix = "string";
        StringCounter++;
    }

    public static void log(boolean message) {
        if (tryToPrintThePreviousValue("boolean")) print();
        Value = message;
        Prefix = "primitive";
    }

    public static void log(Object message) {
        if (tryToPrintThePreviousValue("Object")) print();
        Value = message;
        Prefix = "reference";
    }

    public static void log(byte message) {
        if (tryToPrintThePreviousValue("byte"))
            if (Byte.MAX_VALUE - message > (Byte) Value)
                Value = (Byte) Value + message;
            else {
                print();
                Value = message;
                Prefix = "primitive";
            }
        else {
            Value = message;
            Prefix = "primitive";
        }
    }

    public static void stop() {
        print();
        PreviousType = "stop";
    }

    private static void print() {
        if (Value != null) {
            if (StringCounter > 1) Value = Value.toString() + " (x" + StringCounter + ")";
            System.out.println(Prefix + ": " + Value);
            Value = null;
            Prefix = null;
            StringCounter = 0;
        }
    }

    private static boolean tryToPrintThePreviousValue(String currentType) {
        if (currentType.equals(PreviousType)) return true;
        print();
        PreviousType = currentType;
        return false;
    }
}
