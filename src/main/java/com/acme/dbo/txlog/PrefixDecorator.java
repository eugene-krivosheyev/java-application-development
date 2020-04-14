package com.acme.dbo.txlog;

public class PrefixDecorator implements Decorator {
    private final String prefix;

    public PrefixDecorator(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String decorate(String subject) {
        return String.format("%s: %s", prefix, subject);
    }

    @Override
    public String decorate(String subject, int repetitions) {
        if (repetitions > 1) {
            return String.format("%s (x%d)", this.decorate(subject), repetitions);
        }
        return this.decorate(subject);
    }
}
