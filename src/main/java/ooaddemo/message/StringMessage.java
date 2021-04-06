package ooaddemo.message;

public class StringMessage implements DecoratingMessage {
    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "string: " + body;
    }
}
