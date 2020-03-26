package ooaddemo;

public class MessageLengthLogFilter implements LogFilter {
    private final int MAX_LENGTH;

    public MessageLengthLogFilter(int maxLength) {
        MAX_LENGTH = maxLength;
    }

    @Override
    public boolean filter(String message, int messageSeverity) {
        return message.length() < MAX_LENGTH;
    }
}
