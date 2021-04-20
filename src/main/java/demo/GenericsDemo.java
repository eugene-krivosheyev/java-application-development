package demo;

import java.util.*;

public class GenericsDemo {
    public static void main(String[] args) {
        List objects = new ArrayList();
        objects.add("");

        if (objects.get(0) instanceof String) {
            System.out.println((String) objects.get(0));
        }

        List<String> strings = new ArrayList<>();
//        strings.add(5);
        System.out.println(strings.get(0).toUpperCase());


        ArrayList<? extends Number> numbers = new ArrayList<>();
//        numbers.add(new Integer(0));
        numbers.get(0).intValue();
        //.....
        //.....
        //.....
        //.....

        //Resume:
        List<String> genericStrings = new ArrayList<>();

        getValue(5).intValue();
        GenericsDemo.<String>getValue()
                .toUpperCase();
    }

    private static <U> U getValue(U arg) {
        return null;
    }

    private static <V> V getValue() {
        return null;
    }
}

interface Message<T> {
    T getBody();
    void setBody(T body);
}

class IntMessage1 implements Message {
    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public void setBody(Object body) {

    }
}

class IntMessage2 implements Message<Integer> {
    @Override
    public Integer getBody() {
        return null;
    }

    @Override
    public void setBody(Integer body) {

    }
}

class AbstractMessage<T> implements Message<T> {
    @Override
    public T getBody() {
        return null;
    }

    @Override
    public void setBody(T body) {

    }
}
