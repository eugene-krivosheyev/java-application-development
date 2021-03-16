package demo;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region typing operators
        int var1 = Byte.MAX_VALUE + 130;
        byte var2 = (byte) var1;
        System.out.println(var2);

        //NON-PRIMITIVES!!!
        Object obj = new Integer(1); //polymorphism
        if (obj instanceof String) {
            String result = (String) obj; // -> ClassCastException
        }
        //endregion

        //region Arithmetics operators
        byte b1 = 1, b2 = 3;
        System.out.println( b1 / b2 ); // целочисленный!
        int x = b1 + b2;
        System.out.println(x);
        long l = 1 + 1L;

        System.out.println(1./0.);
        System.out.println(0./0.);
        //endregion

        //region Bitwise
        int v1 = 1, v2 = 2, v3 = -1;
        System.out.println( ~v1 );
        System.out.println( v1 & v2);
        System.out.println( v1 | v2);
        System.out.println( v1 ^ v2);
        System.out.println( v1 << 1);
        System.out.println( v3 >> 1);
        System.out.println( v3 >>> 1);
        //endregion
    }
}
