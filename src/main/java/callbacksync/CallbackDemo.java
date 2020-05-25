package callbacksync;

import java.util.function.Consumer;

public class CallbackDemo {
    public static void main(String[] args) {

    }
}

class Ctrl {
    private Dcrt decorator = new Dcrt();

    public void log() {
        decorator.decorate("abc", this::callback);
    }

    public void callback(String result) {
        System.out.println(result);
    }
}

class Dcrt {
    public void decorate(String message, Consumer<String> handler) {
        String result = message.toUpperCase();
        handler.accept(result);
    }
}

//@FunctionalInterface
//interface ResultHandler {
//    void handle(String result);
//}