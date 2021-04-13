package ooadrefactoring;

public class IntMessage implements Message {
    private int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody() {
        return "primitive: " + body;
    }
}
