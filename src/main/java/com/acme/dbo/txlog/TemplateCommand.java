package com.acme.dbo.txlog;

import java.util.Objects;

public abstract class TemplateCommand implements Command {
    @Override
    public boolean isSame(Command command) {
        return Objects.nonNull(command) && command.getClass().equals(this.getClass());
    }

    @Override
    public boolean isDataOverloaded(Command command) {
        return true;
    }

    @Override
    public Command accumulate(Command command) {
        return this;
    }

    @Override
    public boolean isNotAccumulatable() {
        return true;
    }
}
