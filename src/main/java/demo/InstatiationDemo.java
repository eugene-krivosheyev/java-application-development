package demo;

public class InstatiationDemo {
    public static void main(String[] args) {
        int formak = 1;
//        IntMessage message = new IntMessage(1);
//        IntMessage message2 = IntMessage.getInstance();
    }
}

/**
 * Immutable
 */
class IntMessage {
    private int body;

    /**
     * overloafing
     */
    public IntMessage() {
        this(0); //
    }

    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    IntMessage(final int body) {
        this.body = body;
    }

    public int getBody() {
        return this.body;
    }
}