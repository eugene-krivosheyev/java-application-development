package ooadrecap;

public abstract class CheckingCommand implements Command {
    @Override
    public Command accumulate(Command with) {
        if (with == null) throw new IllegalArgumentException("NNNUUUUULL!!");
        return doAccumulate();
    }

    protected Command doAccumulate() {
        return null;
    }
}
