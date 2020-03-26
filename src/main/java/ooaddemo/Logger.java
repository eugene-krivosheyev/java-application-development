package ooaddemo;

public class Logger {
    public static String message;

    public void log(String message, int severityLevel, int writeMode) {
        if (filter(message, severityLevel)) {
            write(message, writeMode);
        }
    }

    private boolean filter(String message, int severityLevel) {
        return severityLevel < 3;
    }

    private void write(String message, int writeMode) {
        switch (writeMode) {
            case 0: consoleWrite(message); break;
            case 1: fileWrite(message); break;
        }
    }

    private void fileWrite(String message) {

    }

    private void consoleWrite(String message) {
        System.out.println(message);
    }
}
