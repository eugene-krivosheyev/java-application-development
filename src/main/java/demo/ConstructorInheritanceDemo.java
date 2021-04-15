package demo;

public class ConstructorInheritanceDemo {
    public static void main(String[] args) {
        new StringMessage();
    }
}

class Message extends Object {
    public Message() {
    }

    public Message(int arg) {
        System.out.println("M");
    }
}

class StringMessage extends Message {
    StringMessage() {
        this(0); // XOR super();
        System.out.println("SM");
    }

    public StringMessage(int arg) {
    }
}