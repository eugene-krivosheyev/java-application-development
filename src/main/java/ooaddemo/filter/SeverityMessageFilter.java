package ooaddemo.filter;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.domain.message.Message;

public class SeverityMessageFilter implements MessageFilter {
    private final SeverityLevel threshold;

    public SeverityMessageFilter(SeverityLevel threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean filter(Message message, SeverityLevel severity) {
        return severity.compareTo(threshold) < 0;
    }

    public SeverityLevel getThreshold() {
        return threshold;
    }
}
