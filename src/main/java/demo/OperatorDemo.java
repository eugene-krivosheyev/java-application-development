package demo;

import com.sun.xml.internal.xsom.XSUnionSimpleType;
import sun.awt.image.ImageAccessException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;

import static java.lang.Integer.toBinaryString;
import static java.util.stream.IntStream.range;

public strictfp class OperatorDemo {
    static byte counter = Byte.MIN_VALUE;

    public strictfp static void main(String[] args) {
        //region Aritmetics
        System.out.println( 1./3 );
        final long l = 1 + 1L;

        byte b1 = 1, b2 = 1;
        short s1 = 1, s2 = 1;
        final int i = b1 + b2;
        final int i1 = s1 + s2;

        int ii1 = 1, ii2 = 1;
        final int i2 = ii1 + ii2;

        final long l1 = 1L + 1L;

        System.out.println(0./0);
        System.out.println(Double.POSITIVE_INFINITY - 1 == Float.POSITIVE_INFINITY);
        System.out.println(Double.NaN == Double.NaN);
        //endregion

        //region Type overflow
        range(1, 258).forEach( p -> counter++ );
        System.out.println(counter);

        BigInteger bi;
        //endregion

        //region Precision loss
        double d = 1/3.; //IEEE 754
        System.out.println(.1 + .2);

        BigDecimal bd;
        //endregion

        //region Bitwise
        int op1 = 12, op2 = 1;
        System.out.println(op1 | op2);
        System.out.println(op1 & op2);
        System.out.println(op1 ^ op2); //
        System.out.println(~op1);

        System.out.println();
        System.out.println(toBinaryString(12 >> 1));
        System.out.println(toBinaryString(12 >>> 1));
        System.out.println((12 << 34));
//        System.out.println(op1 >> 3);
//        System.out.println(op1 << 1);
        //endregion

        //region Logical
        boolean bb1 = false, bb2 = true;
        System.out.println(bb1() && bb2());
        System.out.println(bb1() || bb2());
        System.out.println(!bb2);
//        fopen('f.txt') or die();

        System.out.println( 1 == 1 ); //= =
        System.out.println( 1.0 == 1.0);
        System.out.println( "o1" == "o1" );
//        System.out.println( 1 === 1 ); //= = =
        System.out.println( "o1".equals("o1"));
        System.out.println( Objects.equals("o1", "o1"));

        System.out.println( 1 != 1 ); //! =
        System.out.println( 2 >= 1 ); //Comaparable.compare | Comparator.comapareTo

        String result = isaBoolean(1, 2) ? "OK" : "notOk";

        int t = 12;
        Object mood = isaBoolean(t, 10) ? "HAPPY" : isaBoolean(t, 0) ? "HAPP?" : "UNhappy";
        //endregion

        //region Controlling flow
        if (false) {
            System.out.println("1");
        } else if (false) {

        }

        String param = "null";
        switch (param) {
            case "a": System.out.println("1"); break;
            case "b": System.out.println("2"); break;
            default: System.out.println("any");
        }

        while (m()) {
            break;
        }

        do {
            break;
        } while (m());

        for (int ii = 0, jj = 0; ii < 10 && jj > 0; ii++, jj--) {
            if (jj >= 0) break;
        }

        System.out.println("===");
        for (String current : args) {
            System.out.println(current);
            if (???) break;
        }

        left: do {} while (m());

        outer: while (true) {
            //...
            inner: do {
                if (???) continue outer;
            } while (true);
            //...
        }
        //endregion
    }

    private static boolean m() {
        return true;
    }

    private static boolean isaBoolean(int i, int i2) {
        return i > i2;
    }

    private static boolean bb2() {
        return false;
    }

    private static boolean bb1() {
        return false;
    }
}
