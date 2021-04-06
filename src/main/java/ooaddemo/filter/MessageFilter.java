package ooaddemo.filter;

import ooaddemo.message.Message;

public interface MessageFilter {
    boolean filter(Message message, int severity);
}
