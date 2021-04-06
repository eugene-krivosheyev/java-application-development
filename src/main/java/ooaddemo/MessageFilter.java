package ooaddemo;

public interface MessageFilter {
    boolean filter(Message message, int severity);
}
