package ooaddemo;

public class Logger {
    public void log(String message, int severityLevel) {
        if (filter(message, severityLevel)) {
            write(message);
        }
    }

    private boolean filter(String message, int severityLevel) {
        return severityLevel < 3;
    }

    private void write(String message) {
        System.out.println(message);
    }
}
