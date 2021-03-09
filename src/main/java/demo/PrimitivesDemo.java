package demo;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.valueOf;

public strictfp class PrimitivesDemo {
    public strictfp static void main(String[] args) {
        //region целочисленные
        byte b = 0b10; // 1 bytes; --0..255-- ^ -128..127
        short s = 010; // 2 bytes;
        int i = 0xABCDEF; // 4 bytes;
        long l = 99_999_999_999L; // 8 bytes;
        System.out.println(">> " + Long.MAX_VALUE);
        //endregion

        //region FP
        //IEEE 754
        float f = -0.f; // 32 bit
        double d = -3e-15; // 64 bit
        //endregion

        //region символьный
        //l10n and i18n
        char c = '\uABCE'; // 2 byte, ꯎ
        int charCode = c;
        System.out.println('\t'); //CSV, TSV
        //endregion

        //region boolean
        // DEFINE true false //счастливой отладки!!!!
        boolean bb = true | false;
        //endregion

        //region Wrappers
        valueOf("10");
        System.out.println(MAX_VALUE);

        final Integer anInteger1 = new Integer(1);
        final int i1 = anInteger1.intValue();

        Integer anInteger2 = 1; // new Integer(1)
        int i2 = anInteger2; // anInteger2.intValue();

        //region Performance issue!!!
        Integer counter = 0;
        while(true) {
            counter++;
        }
        //endregion

        //anInteger.NO_SETTERS!!!!
        //endregion
    }
}
