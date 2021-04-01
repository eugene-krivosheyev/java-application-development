package ooaddemo;


public class Logger {
    private final int threshold = 1;
    private final String filename = "log.txt";

    public void log(String message, int severity) { //0,1,2
        if (filter(message, severity)) {
            print(message);
        }
    }

    private boolean filter(String message, int severity) {
        return severity < threshold;
    }

    private void print(String message) {
        System.out.println("file: " + filename + ", message: " + message);
    }
}
