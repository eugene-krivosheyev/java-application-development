package ooaddemo;

public abstract class ValidatingController {
    public void log(DecoratingMessage message, SeverityLevel severity) {
        if (message == null) throw new IllegalArgumentException("null message");
    }
}
