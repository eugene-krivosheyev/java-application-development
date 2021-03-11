package sandbox;

public class OperatorsDemo {
    public static void main(String[] args){
        //region typ cast operators
        byte var1 = 0;
        int var2 = Byte.MAX_VALUE;
        var1 = (byte)var2;
        System.out.println(var1);
        //endregion

        //region NON primitives
        if("asdasdad" instanceof String) {

        }

        //endregion
    }
}
