package ooaddemo;

public class Severity3LogFilter {
    private int severityLevel;

    public Severity3LogFilter(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public boolean filter(String message) {
        return severityLevel < 3;
    }
}
