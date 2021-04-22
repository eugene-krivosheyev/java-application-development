package demo;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class SyslibDemo {
    public static void main(String[] args) {
        System.getenv();
        System.getProperties()
                .forEach( (k,v) -> System.out.println(k + ":" + v) );
        System.getProperty("file.encoding");

        System.lineSeparator();
//        File.separator;
//        File.pathSeparator;

        System.exit(0);
        System.gc();

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {} ));
        Runtime.getRuntime().availableProcessors();

        //int overflow -> BigInteger: 2^Int.MAX
        //double precision loss -> BigDecimal

        Integer i1 = 129;
        Integer i2 = 129;
        System.out.println(i1 == i2);

//        Arrays.asList(1,2,3,4);
//        Objects.equals("",""); "".equals("");
        //pararm.equals("") -> "".equals(param)
//        Collections.sort();

        new Cat().equals(new Cat());
    }
}

class Cat {
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

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
