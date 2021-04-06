package ooaddemo;

public class StringMessage implements Message {
    private String body;

    public StringMessage(String body) {
        this.body = body;
    }


    @Override
    public String getDecoratedBody() {
        return "string: " + body;
    }
}
