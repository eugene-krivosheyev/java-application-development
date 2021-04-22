package demo;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

public class SyslibDemo {
    public static void main(String[] args) {
        System.getenv();
        System.getProperties()
                .forEach(
                        (k, v) -> System.out.println(k + ":" + v)
                );
//        System.lineSeparator();
//        File.separator
//        File.pathSeparator
        System.gc();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> { }));
        Runtime.getRuntime().gc();

        //int -> 2^int.MAX_VALUE = BigInteger
        //double -> BigDecimal

        Arrays.asList(1,2,3,4);
        Objects.equals("","");

//        cat1.equals(cat2);
    }


}

class Cat implements Cloneable {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
