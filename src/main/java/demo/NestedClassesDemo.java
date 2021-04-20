package demo;

import com.sun.tools.javac.util.List;

import java.util.function.Function;
import java.util.function.Predicate;

public class NestedClassesDemo {
    //state
    public static void main(String[] args) {
        TopLevel.StaticNested o = new TopLevel.StaticNested();

        new TopLevel().new Nested();

        System.out.println(new TopLevel().m().toString());

        template(new Function<String, String>() { // closure
            @Override
            public String apply(String param) {
                o.getStaticOuterState();
                return "";
            }
        });

        template( (String param) -> { return param.toUpperCase(); } );
        template( (param) -> param.toUpperCase()  );
        template( String::toUpperCase );


        System.out.println("=============");
        List.of(1,3,2,4,5).stream()
            .filter(integer -> integer >= 3)
            .map(String::valueOf)
            .map(s -> "string: " + s)
            .forEach(System.out::println);

    }

    private static void template(Function<String, String> todo) {  //HOF
        //....
        //....
        todo.apply("");
        //....
        //....
    }
}

@FunctionalInterface
interface Todo {
    String doit(String param);
}

class TopLevel { //outer
    private static int globalState = 1;
    private int instanceState = 2;

    protected static class StaticNested {
        public void getStaticOuterState() {
            System.out.println(globalState);
        }
    }

    protected class Nested {
        public void getOuterState() {
            System.out.println(TopLevel.this.instanceState);
            System.out.println(globalState);
        }
    }

    public Object m() {
        class LocalNested {
            @Override
            public String toString() {
                return "abc";
            }
        }

        return new LocalNested();
    }

    public Object m2() {
        final int localVar = 1;
        return new Object() {
            @Override
            public String toString() {
                return "" + localVar;
            }
        };
        //.....
    }
}

