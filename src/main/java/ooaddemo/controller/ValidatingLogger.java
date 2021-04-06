package ooaddemo.controller;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.domain.message.Message;

public abstract class ValidatingLogger {
    protected void validate(Message message, SeverityLevel severity) {
        if (message == null) throw new IllegalArgumentException("message is null");
    }
}
