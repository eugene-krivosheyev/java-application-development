package ooaddemo;

public class SeverityMessageFilter {
    private final SeverityLevel threshold;

    public SeverityMessageFilter(SeverityLevel threshold){
        this.threshold = threshold;
    };

    public boolean filter(String message, SeverityLevel severity) {

        return severity.compareTo(threshold) < 0;
    }

}
