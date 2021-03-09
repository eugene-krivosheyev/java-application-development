package demo;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region целочисленные
        byte b = -0b1; //--0..255-- ^ -127..128 //IEEE 754
        short s = 022354; // 2 bytes:
        int i = 0xABCDEF; // 4 bytes
        long l = 9_999_999_999_999L; // 8 bytes
        //endregion

        //region wrappers
        System.out.println(Short.MAX_VALUE);
        //endregion
    }
}
