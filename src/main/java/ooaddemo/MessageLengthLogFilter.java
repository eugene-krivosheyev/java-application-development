package ooaddemo;

public class MessageLengthLogFilter {
    private final int MAX_LENGTH;

    public MessageLengthLogFilter(int maxLength) {
        MAX_LENGTH = maxLength;
    }

    public boolean filter(String message, int messageSeverity) {
        return message.length() < MAX_LENGTH;
    }
}
