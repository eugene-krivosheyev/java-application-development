package ooaddemo;

public class MessageSeverityLogFilter implements LogFilter {
    private final int MAX_SEVERITY;

    public MessageSeverityLogFilter(int maxSeverity) {
        MAX_SEVERITY = maxSeverity;
    }

    @Override
    public boolean filter(String message, int messageSeverity) {
        return messageSeverity < MAX_SEVERITY;
    }
}
