package com.acme.dbo.txlog.message;

import java.util.Arrays;

public abstract class MessageBase {

    public abstract String toString();

    public static String arrayToString(int[] intArray){
        String arrayStr = Arrays.toString(intArray);
        return arrayStr.substring(1, arrayStr.length() - 1);
    }

}
