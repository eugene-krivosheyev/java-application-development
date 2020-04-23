package genericsdemo;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        List<? extends Object> genericList = new ArrayList<String>();
        List<String> strList = new ArrayList<>();

        MyList<String> stringList = new MyList<>();//
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        String max = MyListUtil.<String>max(stringList);
        MyListUtil.transform("");
    }
}

class MyListUtil {
    public static <T,U,V> U transform(T toTransform, V param) {
        return null;
    }

    public static <T extends Number> T max(MyList<T> toGetMAx) {
        return null;
    }
}

class MyList<T extends Number> {
    private T elem;

    public static void sort() {

    }

    public void add(T toAdd) {
        elem = toAdd;
    }

    public T get() {
        return null;
    }
}

class FileMyList<T> extends MyList<T> {
    @Override
    public T get() {
        return null;
    }
}

class FL2 extends MyList<Integer> {
    @Override
    public Integer get() {
        return null;
    }
}



