package demo;

import java.util.Objects;

public class InterningDemo {
    public static void main(String[] args) {
        String str1 = "abc"; //string ~pool~ cache
        String str2 = new String("abc");
        final String internedStr2 = str2.intern();

        String str3 = "abc";
        str3.toUpperCase(); //Immutable! -> StringBuilder & StringBuffer
        System.out.println(str3);

        System.out.println( str1 == str3 );


        System.out.println("a" + "b" + "c" + "d"); //a, b, ab, c, abc
        System.out.println(
            new StringBuffer("a")
                .append("b")
                .append("c")
                .append("d")
        );


        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);

        Character c1 = '\uABCD';
        Character c2 = '\uABCD';
        System.out.println(c1 == c2);

        Double f1 = 1.0;
        Double f2 = 1.0;
        System.out.println(f1 == f2);

        Boolean b1 = false;
        Boolean b2 = false;
        System.out.println(b1 == b2);

        System.out.println(i1.equals(i2));
        System.out.println(Objects.equals(i1, i2));
    }
}
