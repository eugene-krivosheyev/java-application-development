package demo;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class OperatorsDemo {
    static byte counter = Byte.MIN_VALUE;

    public static void main(String[] args) {
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
    }
}
