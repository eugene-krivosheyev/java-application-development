package demo;

import java.util.Objects;

public class InterningDemo {
    public static void main(String[] args) {
        String s1 = new String("abc"); //String ~pool~ cache
        String s2 = new String(s1);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(Objects.equals(s1, s2));

        s1.toUpperCase(); //Bug!
        System.out.println(s1);

        Integer i1 = 128;  //256
        Integer i2 = 128;
        System.out.println( i1 == i2 );

        Long l1 = 1L;
        Long l2 = 1L;
        System.out.println(l1 == l2);

        Float f1 = 0.111112f;
        Float f2 = 0.111111f;
        System.out.println( f1 == f2 );

        Character c1 = '\u0079';
        Character c2 = '\u0079';
        System.out.println(c1 == c2);

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2);

        System.out.println("a" + "b" + "c" + "d"); //a,b,ab,c,abc,d,abcd
        new StringBuffer("a")
            .append("b")
            .append("c")
            .append("d");

        String.format("%s %s", s1, s2);
    }
}
