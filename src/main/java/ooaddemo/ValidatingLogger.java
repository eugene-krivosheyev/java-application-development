package ooaddemo;

public abstract class ValidatingLogger {
    protected void validate(String message, int severity) {
        if (message == null) throw new IllegalArgumentException("message is null");
    }
}
