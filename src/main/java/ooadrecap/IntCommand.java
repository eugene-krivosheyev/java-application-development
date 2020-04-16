package ooadrecap;

public class IntCommand extends CheckingCommand {
    private int message;

    public IntCommand(int message) {
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
