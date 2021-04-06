package ooaddemo.controller;

import ooaddemo.message.Message;

public abstract class ValidatingLogger {
    protected void validate(Message message, int severity) {
        if (message == null) throw new IllegalArgumentException("message is null");
    }
}
