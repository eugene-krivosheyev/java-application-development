package demo;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region целочисленные
        byte b = 0b10; // 1 bytes; --0..255-- ^ -128..127
        short s = 010; // 2 bytes;
        int i = 0xABCDEF; // 4 bytes;
        long l = 99_999_999_999L; // 8 bytes;
        l = 3;
        l++;
        System.out.println("dfsdfgdf" + Long.MAX_VALUE);
        //endregion

        //region FP
        //endregion

        //region Wrappers
        final Integer anInteger = new Integer(2);
//        anInteger.NO_SETTERS!!!!
        //endregion
    }
}
