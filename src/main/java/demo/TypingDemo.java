package demo;

public class TypingDemo {
    public static void main(String[] args) {
        int ii = 1_000;
        System.out.println( (byte)ii );

        int i = -1;
        final char c = (char) i;
        System.out.println( (int)c );
        System.out.println(c);

        Object object = new String("abc");

        if (object instanceof String) {
            final String object1 = (String) object;
        }

        System.out.println("a" + object.toString());
    }
}
