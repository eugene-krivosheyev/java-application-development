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
    }
}
