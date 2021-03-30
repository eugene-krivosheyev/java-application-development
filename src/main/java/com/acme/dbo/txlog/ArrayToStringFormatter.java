package com.acme.dbo.txlog;

public class ArrayToStringFormatter implements Format {

    private static String LEFT_BRACKET = "{";
    private static String RIGHT_BRACKET = "}";
    private static String ARRAY_DIVIDER = ", ";

     public String format(int[] array) {
        String result = LEFT_BRACKET;
        for (int i = 0; i < array.length; ++i)
        {
            result += array[i];
            if (i != array.length - 1) {
                result += ARRAY_DIVIDER;
            }
        }
        result += RIGHT_BRACKET;
        return result;
    }

     public String format(int[][] array) {
        String result = LEFT_BRACKET + System.lineSeparator();
        for (int i = 0; i < array.length; ++i)
        {
            result += this.format(array[i]) + System.lineSeparator();
        }
        result += RIGHT_BRACKET;
        return result;
    }
}
