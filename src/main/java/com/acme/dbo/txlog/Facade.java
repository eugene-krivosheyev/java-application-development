package com.acme.dbo.txlog;



public class Facade {

    private static String stringAccum;
    private static int sequenceCounter = 0;

    private static int intAccum;

    private static byte byteAccum;

    private static String messageType;

    public static void log(int message) {
        messageType = "integer";
        clearOptional();

        if (message == 0 && intAccum == 0) {
            clearIntAccum(message);
        }
        else if (message == 0 && intAccum != 0) {
            clearIntAccum();
            clearIntAccum(message);
        }
        else {
            intAccumulation(message);
        }
    }

    private static void intAccumulation(int message) {
        try {
            intAccum = Math.addExact(intAccum, message);
        }
        catch(ArithmeticException e) {
            clearIntAccum();
            log(message);
            }
    }

    public static void log(byte message) {
        messageType = "byte";
        clearOptional();

        if (message == 0 && byteAccum == 0) {
            clearIntAccum(message);
        }
        else if (message == 0 && byteAccum != 0) {
            clearByteAccum();
            clearByteAccum(message);
        }
        else {
            byteAccumulation(message);
        }
    }

    private static void byteAccumulation(byte message) {
        if (byteAccum + message > Byte.MAX_VALUE) {
            clearByteAccum();
            log(message);
        }
        else {byteAccum += message;}
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        messageType = "string";
        if (stringAccum == null) {
            clearOptional();
            stringAccum = message;
            sequenceCounter++;
        }
        else if (stringAccum.equals(message)) {
            sequenceCounter++;
        }
        else if (!stringAccum.equals(message) && sequenceCounter > 0) {
            clearStringAccum(message);
        }
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        if (message instanceof int[]) {

        }
        else if (message instanceof int[][]) {
            System.out.println("primitives matrix: {");
            for (int[] i: ((int[][]) message)) {
                String result = "{";
                for (int k = 0; k < i.length; k++) {
                    result = result + i[k] + ", ";
                }
                System.out.println(result.substring(0, result.length() - 2) + "}");
            }
            System.out.println("}");
        }
        else if (message instanceof int[][][][]) {
            System.out.println("primitives multimatrix: {");
            for (int[][][] i: ((int[][][][]) message)) {
                System.out.println("{");
                for (int[][] k: i) {
                    System.out.println("{");
                    for (int[] j: k) {
                        System.out.println("{");
                        for (int v = 0; v < i.length; v++) {
                            System.out.println(j[v]);
                        }
                        System.out.println("}");
                    }
                    System.out.println("}");
                }
                System.out.println("}");
            }
            System.out.println("}");
        }
        else {
            System.out.println("reference: " + message);
        }
    }

    private static void clearOptional() {
        switch (messageType){
            case "integer": clearStringAccum();
                clearByteAccum();
                break;
            case "byte": clearStringAccum();
                clearIntAccum();
                break;
            case "string": clearByteAccum();
                clearIntAccum();
                break;
            default: clearStringAccum();
                clearIntAccum();
                clearByteAccum();
                break;
        }
    }

    public static void clear() {
        clearStringAccum();
        clearIntAccum();
        clearByteAccum();
    }

    private static void clearStringAccum(String message) {
        String postfix = "";
        if (sequenceCounter > 1) {postfix = " (x" + sequenceCounter + ")";}
        System.out.println("string: " + stringAccum + postfix);
        sequenceCounter = 1;
        stringAccum = message;
    }

    private static void clearStringAccum() {
        if (stringAccum != null) {
            String postfix = "";
            if (sequenceCounter > 1) {postfix = " (x" + sequenceCounter + ")";}
            System.out.println("string: " + stringAccum + postfix);
        }
        sequenceCounter = 0;
        stringAccum = null;
    }

    private static void clearIntAccum() {
        if (intAccum != 0) {
            clearNumericAccum(intAccum);
            intAccum = 0;
        }
    }

    private static void clearIntAccum(int message) {
        clearNumericAccum(message);
    }

    private static <T extends Number> void clearNumericAccum(T message) {
        System.out.println("primitive: " + message);
    }

    private static void clearByteAccum() {
        if (byteAccum != 0) {
            clearNumericAccum(byteAccum);
            byteAccum = 0;
        }
    }


    private static void clearByteAccum(byte message) {
        clearNumericAccum(message);
    }

    public static void log(String ...message) {
        for (String s: message) {
            System.out.println(s);
        }
    }

    public static void log(int ...message) {
        int result = 0;
        for (int i: message) {
            result += i;
        }
        System.out.println(result);
    }

}
