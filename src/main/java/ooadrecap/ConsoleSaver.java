package ooadrecap;

public class ConsoleSaver implements Saver {
    @Override
    public void save(Command currentState) {
        System.out.println(currentState.getDecoratedMessage());
    }
}
