package demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;

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
    }
}
