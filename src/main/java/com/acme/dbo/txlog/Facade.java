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

    public static void log(int[] message) {
        if (tryToPrintThePreviousValue("array")) print();
        Value = convertArrayToString(message);
        Prefix = "primitives array";
    }

    public static void log(int[][] message) {
        if (tryToPrintThePreviousValue("matrix")) print();
        Value = convertArrayToString(message);
        Prefix = "primitives matrix";
    }

    public static void log(int[][][] message) {
        if (tryToPrintThePreviousValue("multimatrix")) print();
        Value = convertArrayToString(message);
        Prefix = "primitives multimatrix";
    }

    public static void log(int[][][][] message) {
        if (tryToPrintThePreviousValue("multimatrix2")) print();
        Value = convertArrayToString(message);
        Prefix = "primitives multimatrix";
    }

    public static void log(String... message) {
        for (String i : message) log(i);
    }

    public static void stop() {
        print();
        PreviousType = "stop";
    }

    private static String convertArrayToString(int[] array) {
        StringBuilder value = new StringBuilder("{");
        for (int i : array) value.append(i).append(", ");
        value.delete(value.length() - 2, value.length()).append("}");
        return value.toString();
    }

    private static String convertArrayToString(int[][] array2) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[] array : array2) value.append(convertArrayToString(array)).append(System.lineSeparator());
        value.delete(value.length() - 2, value.length()).append(System.lineSeparator()).append("}");
        return value.toString();
    }

    private static String convertArrayToString(int[][][] array3) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[][] array2 : array3) value.append(convertArrayToString(array2)).append(System.lineSeparator());
        value.delete(value.length() - 2, value.length()).append(System.lineSeparator()).append("}");
        return value.toString();
    }

    private static String convertArrayToString(int[][][][] array4) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[][][] array3 : array4) value.append(convertArrayToString(array3)).append(System.lineSeparator());
        value.delete(value.length() - 2, value.length()).append(System.lineSeparator()).append("}");
        return value.toString();
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
