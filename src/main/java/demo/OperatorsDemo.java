package demo;

import java.math.BigDecimal;
import java.math.BigInteger;
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


    }
}
