package com.acme.dbo.txlog;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayToStringFormatter implements Format {

    private static String LEFT_BRACKET = "{";
    private static String RIGHT_BRACKET = "}";
    private static String ARRAY_DIVIDER = ", ";

     public String format(int[] array) {
        return LEFT_BRACKET + Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(ARRAY_DIVIDER)) + RIGHT_BRACKET;
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
