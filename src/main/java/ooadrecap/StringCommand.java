package ooadrecap;

public class StringCommand extends CheckingCommand {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    protected Command doAccumulate() {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}
