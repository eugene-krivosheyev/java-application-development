package ooaddemo;

public class MessageLengthLogFilter implements LogFilter {
    private final int lengthLimit;

    public MessageLengthLogFilter(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    @Override
    public boolean filter(String message) {
        return message.length() < lengthLimit;
    }
}
