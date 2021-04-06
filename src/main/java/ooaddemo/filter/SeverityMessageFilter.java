package ooaddemo.filter;

import ooaddemo.message.Message;

public class SeverityMessageFilter implements MessageFilter {
    private final int threshold;

    public SeverityMessageFilter(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean filter(Message message, int severity) {
        return severity < threshold;
    }

    public int getThreshold() {
        return threshold;
    }
}
