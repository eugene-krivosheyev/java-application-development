package ooadrefactoring;

public class IntMessage {
    private int body;

    public IntMessage(int body) {
        this.body = body;
    }

    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof IntMessage;
    }

    public IntMessage accumulate(IntMessage newMessage) {
        return new IntMessage(this.body + newMessage.body);
    }

    @Override
    public String toString() {
        return "primitive: " + body;
    }
}
