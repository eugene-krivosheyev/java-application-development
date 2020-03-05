package demo;

import static java.lang.Float.parseFloat;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region Evens
        byte b = 0; //-127..128
        short s = 0b10; //0b, 0x, 0
        int i = 1_000_000_000;
        long l = 999_999_999_999L;
        //endregion

        //region Fractions
        float f = 0.1f; //IEEE 754
        double d = -0x2_00e-03d;
        //endregion

        //region Symbol
        char c = '\uABCD' + '\t';//'我';
        int charCode = c;
        System.out.println(charCode);
        System.out.println((char)++charCode);

        System.out.println((char) (c + 1));
        //endregion

        //region Logic
        boolean bb = true | false;
        //endregion

        //region Wrappers
        java.lang.Byte bbb;
        Short sss;
        Integer iii;
        Long lll;

        Character ccc;
        Boolean bbbb;

        parseFloat("-01e-4");

        Integer i1 = 1000; //auto-boxing
        Integer i2 = 1000; //auto-boxing
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer accumulator = 0;
        for (int counter = 0; counter < 10_000; counter++) {
            accumulator++;
            //accumulator = new Integer(accumulator.intValue() + 1);
        }


        Integer acc2 = new Integer(0);
        int acc = acc2.intValue();

        Integer acc3 = new Integer(2);
        int acc4 = acc3.intValue();
        //endregion
    }
}
