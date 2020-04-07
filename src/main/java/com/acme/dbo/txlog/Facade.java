package com.acme.dbo.txlog;

enum Type {
    INT("primitive"), BOOL("primitive"), BYTE("primitive"),
    CHAR("char"), STR("string"), OBJ("reference"),
    ARRAY("primitives array"), MATRIX("primitives matrix"), MULTIMATRIX("primitives multimatrix"),
    SERVICE("");

    private String prefix;

    Type(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}

public class Facade {
    private static Type PreviousType = Type.SERVICE;
    private static Object Value;
    private static int StringCounter;

    public static void log(int message) {
        if (tryToPrintThePreviousValue(Type.INT))
            if (Integer.MAX_VALUE - message > (Integer) Value)
                Value = (Integer) Value + message;
            else {
                print();
                Value = message;
            }
        else {
            Value = message;
        }
    }

    public static void log(char message) {
        if (tryToPrintThePreviousValue(Type.CHAR)) print();
        Value = message;
    }

    public static void log(String message) {
        if (tryToPrintThePreviousValue(Type.STR) && !message.equals(Value)) print();
        Value = message;
        StringCounter++;
    }

    public static void log(boolean message) {
        if (tryToPrintThePreviousValue(Type.BOOL)) print();
        Value = message;
    }

    public static void log(Object message) {
        if (tryToPrintThePreviousValue(Type.OBJ)) print();
        Value = message;
    }

    public static void log(byte message) {
        if (tryToPrintThePreviousValue(Type.BYTE))
            if (Byte.MAX_VALUE - message > (Byte) Value)
                Value = (Byte) Value + message;
            else {
                print();
                Value = message;
            }
        else {
            Value = message;
        }
    }

    public static void log(int[] message) {
        if (tryToPrintThePreviousValue(Type.ARRAY)) print();
        Value = convertArrayToString(message);
    }

    public static void log(int[][] message) {
        if (tryToPrintThePreviousValue(Type.MATRIX)) print();
        Value = convertArrayToString(message);
    }

    public static void log(int[][][] message) {
        print();
        PreviousType = Type.MULTIMATRIX;
        Value = convertArrayToString(message);
        print();
    }

    public static void log(int[][][][] message) {
        print();
        PreviousType = Type.MULTIMATRIX;
        Value = convertArrayToString(message);
        print();
    }

    public static void log(String... message) {
        for (String i : message) log(i);
    }

    public static void stop() {
        print();
        PreviousType = Type.SERVICE;
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
            System.out.println(PreviousType.getPrefix() + ": " + Value);
            Value = null;
            StringCounter = 0;
        }
    }

    private static boolean tryToPrintThePreviousValue(Type currentType) {
        if (currentType.equals(PreviousType)) return true;
        print();
        PreviousType = currentType;
        return false;
    }
}
