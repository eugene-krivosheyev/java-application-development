package demo;

import static java.lang.Byte.MAX_VALUE;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region evens
        byte b = 0; //-128..127
        short s = 0b10;
        int i = 100_000_000;
        long l = 999999999999L;
        //endregion

        //region fractions
        float f = -0x30e-2f; //IEEE 754
        double d = 0_0.d;
        //endregion

        //region logical
        boolean bb = true | false;
        //endregion

        //region symbol
        char c = '\b'; //0..65xxx
        System.out.println(c);

        char c2 = '\uAB12';
        int cToS = c2;
        System.out.println((char)(cToS));
        System.out.println((char)(++cToS));
        //endregion

        //region Wrapper
        java.lang.Byte bbb;
        Short sss;
        Integer iii;
        Long lll;

        Boolean boo;
        Character cc;

        System.out.println(MAX_VALUE);
        //endregion

        //region *Auto* boxing/unboxing
        final Integer wrappedInt = new Integer(1);
        final int unwrappedInt = wrappedInt.intValue();

        Byte wrappedByte = 1; //new Byte(!)
        byte uwrappedByte = wrappedByte; //.byteValue()

        Integer accumulator = 0;
        for (int counter = 0; counter < 1_000_000; counter++) {
            accumulator++; //new Integer(acc.intValue() + 1)
        }
        //endregion
    }
}
