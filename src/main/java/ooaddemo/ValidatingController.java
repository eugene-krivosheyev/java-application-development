package ooaddemo;

public abstract class ValidatingController {
    public void log(String message, SeverityLevel severity) {
        if (message == null) throw new IllegalArgumentException("null message");
    }
}
