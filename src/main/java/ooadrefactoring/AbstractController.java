package ooadrefactoring;

public abstract class AbstractController {
    public void log(Message newMessage) {
        if (newMessage == null) throw new IllegalArgumentException();
    }
}
