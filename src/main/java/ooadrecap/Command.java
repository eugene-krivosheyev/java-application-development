package ooadrecap;

public interface Command {
    Command accumulate(Command with);
    String getDecoratedMessage();
}
