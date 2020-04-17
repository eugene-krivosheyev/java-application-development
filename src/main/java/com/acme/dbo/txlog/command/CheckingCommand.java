package com.acme.dbo.txlog.command;

public abstract class CheckingCommand implements Command{

    public boolean isSame(Command command) {
        if (this.getClass() == command.getClass()) {
            return this.checkIsSame(command);
        } else {
            return false;
        }
    }

    public String decoratedMessage() {
        return this.getPrefix() + this.getStringMessage() + this.getAdditionalDecoration();
    }

    public boolean checkNoOverflow(Command command) {
        return true;
    }

    protected boolean checkIsSame(Command command){
        return true;
    }

    protected String getPrefix() {
        return "";
    }

    protected String getStringMessage() {
        return "";
    }

    protected String getAdditionalDecoration() {
        return "";
    }
}
