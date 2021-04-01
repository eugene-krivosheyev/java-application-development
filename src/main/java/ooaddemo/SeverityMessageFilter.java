package ooaddemo;

public class SeverityMessageFilter {
    private final int threshold;

    public SeverityMessageFilter(int threshold) {
        this.threshold = threshold;
    }

    public boolean filter(String message, int severity) {
        return severity < threshold;
    }
}
