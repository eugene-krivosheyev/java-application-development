package demo;

import java.util.Optional;

public class TypingDemo {
    public static void main(String[] args) {
        int i = 130;
        byte castedInt = (byte) i;
        System.out.println(castedInt);

        char c = '\u00FF';
        byte s = (byte) c;
        System.out.println(s);


        Object o = new Integer(1);
        if (o instanceof String) {
            final String castedO = (String) o; //ClassCastException
        } else if (o instanceof Integer) {

        } else if (o instanceof Integer) {

        }

        final Object o1 = null;
        System.out.println(null == null);
    }

    static Optional<Integer> m() {
        return null;
    }
}
