package ooaddemo;

public class Severity3LogFilter implements LogFilter {
    private int severityLevel;

    public Severity3LogFilter(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    @Override
    public boolean filter(String message) {
        return severityLevel < 3;
    }
}
