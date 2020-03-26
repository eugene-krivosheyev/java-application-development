package ooaddemo;

public class Logger {
    private static int maxSeverity;
    private static int writeMode;

    public static void log(String message, int messageSeverity) {
        if (filter(message, messageSeverity)) {
            write(message);
        }
    }

    private static boolean filter(String message, int messageSeverity) {
        return messageSeverity < maxSeverity;
    }

    private static void write(String message) {
        switch (writeMode) {
            case 0: System.out.println(message); break;
            case 1: break;
        }
    }
}
