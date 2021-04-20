package demo;

import com.sun.tools.javah.Gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericsDemo {
    public static void main(String[] args) {
        //region before 5
        List stringsAsObjects = new ArrayList();
        stringsAsObjects.add("");
        stringsAsObjects.add(5);

        if (stringsAsObjects.get(0) instanceof String) {
            System.out.println(
                    (String) stringsAsObjects.get(0)
            );
        }
        //endregion

        //region after 5
        List<String> strings = new ArrayList<String>(); // diamond operator
        strings.add(""); // + add(Object)
//        strings.add(5);
        System.out.println( strings.get(0).toUpperCase() );
        //endregion

        List<Number> numbers = new ArrayList<>(); // diamond operator
        numbers.add(new Integer(0));
        numbers.add(new Byte((byte)0));
        System.out.println(numbers.get(0));
        //.....
        //number
        //......

        // how to use with inheritance
        GenericMessage<Integer> intMessage1 = new IntMessage1();
        intMessage1.getBody().intValue();

        GenericMessage<Integer> intMessage2 = new IntMessage2();

        GenericMessage<Integer> intMessage3 = new AbstractMessage3<Integer>();

        m1(5).intValue();
        GenericsDemo.<String>m2().toUpperCase();
    }

    private static <U> U m1(U param) {
        return null;
    }

    private static <U> U m2() {
        return null;
    }
}

interface GenericMessage<T> {
    T getBody();
    void setBody(T body);
}

class IntMessage1 implements GenericMessage {
    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public void setBody(Object body) {

    }
}

class IntMessage2 implements GenericMessage<Integer> {
    @Override
    public Integer getBody() {
        return null;
    }

    @Override
    public void setBody(Integer body) {

    }
}

class AbstractMessage3<T> implements GenericMessage<T> {
    @Override
    public T getBody() {
        return null;
    }

    @Override
    public void setBody(T body) {

    }
}