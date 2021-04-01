package ooaddemo;

public interface MessageFilter {
    boolean filter(String message, SeverityLevel severity);
}
