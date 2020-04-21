package com.acme.dbo.txlog.decorators;

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
    public String decorate(String subject, int count) {
        if (count > 1) {
            return String.format("%s (x%d)", this.decorate(subject), count);
        }
        return this.decorate(subject);
    }
}
