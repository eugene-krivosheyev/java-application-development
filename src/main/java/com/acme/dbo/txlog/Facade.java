package com.acme.dbo.txlog;

public class Facade {
    private static boolean isLoggedIntOnPrevious = false;
    private static long summ = 0;
    public static void log(int message) {
        isLoggedIntOnPrevious = true;
        if (summ + message > Integer.MAX_VALUE) {
            printSumm();
            isLoggedIntOnPrevious = true;
        }
        summ += message;
        if (summ == 0) printSumm();
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    private static void printSumm() {
        if (isLoggedIntOnPrevious) {
            System.out.println(summ);
            summ = 0;
            isLoggedIntOnPrevious = false;
        }
    }

    public static void log(String message) {
        printSumm();
        System.out.println(message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(boolean b) {
        System.out.println("primitive: " + b);
    }

    public static void log(Object o) {
        System.out.println("reference: " + o);
    }
}
