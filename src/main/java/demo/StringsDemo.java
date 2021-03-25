package demo;

import java.util.Locale;

public class StringsDemo {
    public static void main(String[] args) {
        String str1 = "abc"; //new String() + intern()
        String str2 = "abc"; //new String() + intern()
        String internedStr1 = str1.intern();

        System.out.println( str1 == str2 );

        String str = "a";
        str.toUpperCase();
        System.out.println(str);
        System.out.println(str.toUpperCase());

        StringBuffer sbf; //Thread-safe, synchronized
        StringBuilder sbr; //Thread-unsafe
        System.out.println( "a" + "b" + "c" + "d" );
        sbf = new StringBuffer("a")
            .append("b")
            .append("c")
            .append("d");



        Integer i1 = 128; //new Integer() + intern()
        Integer i2 = 128;
        System.out.println( i1 == i2 );
    }
}
