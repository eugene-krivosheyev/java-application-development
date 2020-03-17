package demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class OperatorsDemo {
    static byte counter = Byte.MIN_VALUE;

    public strictfp static void main(String[] args) {
        //region Arithmetics
        System.out.println(1./0);

        byte b1 = 1, b2 = 1;
        final int result = b1 + b2;

        int i1 = 1, i2 = 1;
        final int i = i1 + i2;

        final long l = i1 + 1L;

        final float fr = 1f * 1f;
        final double dr = 1f + 1d;

        System.out.println(10 % 3.3);
        //endregion

        //region Type Overflow
        range(1, 260).forEach( p -> counter++ );
        System.out.println(counter);
        //endregion

        //region Precision Loss
        double dd = 1/3.; //IEEE 754
        System.out.println(.1 + .2);

        BigInteger bi; //overflow killer
        BigDecimal bd; //precision loss killer
        //endregion

        //region Bitwise
        int iii1 = 12, iii2 = 1;
        System.out.println(iii1 & iii2);
        System.out.println(iii1 | iii2);
        System.out.println(iii1 ^ iii2);
        System.out.println(~iii2);

        System.out.println(iii1 >> 34);
        System.out.println(iii1 >>> 2);
        System.out.println(iii1 << 2);
        //endregion

        //region Logical
        boolean bb1 = false, bb2 = false;
        System.out.println( bb1() && bb2() );
        System.out.println( bb1 || bb2 );
        System.out.println( !bb2 );
        Objects.equals("", "");
//        fopen('ddd') or die();

        System.out.println(1 == 1); //= =
        System.out.println(1 != 1); //! =
        System.out.println(1 >= 1); //> =
        System.out.println(new Integer(1).equals(1));
        System.out.println(Objects.equals("a", "a"));
        //a === b; //= = =

        Object toResult = 1 > 2 ? "lazha" :  1 == 3 ? "O" : 0;

        String pogoda = "Arghhhh :(";
        System.out.println(
                pogoda.equals("Ok") ? 10 : 0
        );
        //endregion

        //region Switching
        if (true) {

        } else if (false) {

        } else {

        }

        System.out.println();
        String sw = "null";
        switch (sw) {
            case "R": todo("!!!"); break;
            case "G": todo("???"); break;
            case "B": todo("???"); break;
            default: todo("default"); break;
        }
        //endregion

        //region Loops
        while (m()) {

        }



        outer: for(String current : args) {
            for (int c = 0, j = 1; c < 10_000; c++, j++) {
                do {
                    //++++
                    if (m()) continue outer;
                    //-----
                } while (m());
            }
            System.out.println(current);

        }
        //endregion
    }

    private static void todo(String s) {
        System.out.println(s);
        System.out.println(s);
    }

    private static boolean bb2() {
        return false;
    }

    private static boolean bb1() {
        return false;
    }

    private static boolean m() {
        return false;
    }
}

enum Color {
    R, G, B
}
