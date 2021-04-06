package ooaddemo.filter;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.domain.message.Message;

public interface MessageFilter {
    boolean filter(Message message, SeverityLevel severity);
}
