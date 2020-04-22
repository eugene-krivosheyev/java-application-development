package com.acme.dbo.txlog.commands;

abstract public class BaseCommand implements Command {

    public static final BaseCommand EMPTY_COMMAND = new BaseCommand() {
        @Override
        protected String getDecorator() {
            return null;
        }

        @Override
        public String getMessage() {
            return null;
        }
    };

    abstract protected String getDecorator();
    public String getDecoratedMessage() {
        return getDecorator() + getMessage();
    }

    @Override
    public boolean shouldAppend(Command state) {
        return false;
    }

    public Command append(Command state) {
        return null;
    }
}
