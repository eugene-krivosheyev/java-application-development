package ooaddemo;

public interface MessageFilter {
    boolean filter(DecoratingMessage message, SeverityLevel severity);
}
