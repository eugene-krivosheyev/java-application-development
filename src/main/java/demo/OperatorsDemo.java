package demo;

import javax.xml.ws.soap.Addressing;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.of;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region Type operators
        byte b = 0;
        int i = b; //implicit type casting

        i = Byte.MAX_VALUE + 1;
        b = (byte) i; //unary operator
        System.out.println(b);

        Object object = new Integer("abc"); // polymorphism
        if (object instanceof String) {
            System.out.println(( (String) object )); // ClassCastException
        }
        //endregion

        Object obj = new Object();
        String s = "abc"; // new String("abc)
        Integer integer = 1; // new Integer(1)
        int[] array = {1,2,3}; //
        Optional maybe = of("125.7.8.6:666"); // Factory Method
        final List<Object> objects = emptyList();
    }
}
