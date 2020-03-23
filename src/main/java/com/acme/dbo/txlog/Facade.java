package com.acme.dbo.txlog;

public class Facade {

    private static int FINAL_MESSAGE = 0;
    private static boolean SUM_TRIGGER = false;
    private static boolean FINAL_INT = false;

    public static void log(int message) {
        if (SUM_TRIGGER) {
            try {
                FINAL_MESSAGE = Math.addExact(FINAL_MESSAGE, message);
            }
            catch (ArithmeticException e) {
                System.out.println(FINAL_MESSAGE);
                System.out.println(message);
                FINAL_MESSAGE = 0;
            }
        }
        else if (FINAL_INT) {
            System.out.println(message);
            FINAL_INT = false;
        }
        else {
            System.out.println("primitive: " + message);
        }
    }

    public static void log(byte message) {
        if (SUM_TRIGGER) {
            if ((Math.addExact((byte)FINAL_MESSAGE, (byte)message)) < Byte.MAX_VALUE) {
                FINAL_MESSAGE = Math.addExact((byte)FINAL_MESSAGE, (byte)message);
            }
            else {
                System.out.println(FINAL_MESSAGE);
                System.out.println(message);
                FINAL_MESSAGE = 0;
            }
        }
        else {
            System.out.println("primitive: " + message);
        }
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {

        switch (message) {
            case ("str 1"):
                System.out.println(message);
                SUM_TRIGGER = true;
                break;
            case ("str 2"):
                if (FINAL_MESSAGE != 0) {
                    System.out.println(FINAL_MESSAGE);
                    FINAL_MESSAGE = 0;
                }
                SUM_TRIGGER = false;
                FINAL_INT = true;
                System.out.println(message);
                break;
            case ("str 3"):

            default: System.out.println("string: " + message);
                SUM_TRIGGER = false;
                break;
        }
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }


}
