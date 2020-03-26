package ooaddemo;

public class LogFilter {
    private int severityLevel;

    public LogFilter(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public boolean filter(String message) {
        return severityLevel < 3;
    }
}
