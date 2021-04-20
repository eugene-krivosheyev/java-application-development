package demo;

import com.sun.tools.javac.util.List;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class NestedClassesDemo {
    public static void main(String[] args) {
        TopLevelOuter.StaticNested nestedObj = new TopLevelOuter.StaticNested();
        nestedObj.getStaticOuterState();

        new TopLevelOuter().new Nested();

        System.out.println(
                new TopLevelOuter().outerMethod().toString()
        );


        reusableM( //HOF
                new Todo() { //anonymous local nested class
                    @Override
                    public String todo() { //closure
                        return "890";
                    }
                }
        );
        reusableM(() -> "null");

        reusableM2(new Todo2() {
            @Override
            public String todo(String arg) {
                return null;
            }
        });
        reusableM2( (String arg) -> { return "string: " + arg; } );
        reusableM2( (arg) -> { return "string: " + arg; } );
        reusableM2( arg -> "string: " + arg ); // - >

        reusableM3( arg -> "string: " + arg ); // - >

        //Stream API
        List.of(1,3,2,4).stream()
                .filter(e -> e >= 2)
                .map(String::valueOf)
                .map(e -> ": " + e)
                .map(e -> "string " + e)
                .forEach(System.out::println); // - >

    }

    private static void reusableM(Todo todo) {
        //....
        //....
        System.out.println(
            todo.todo()
        );
        //....
        //....
    }

    private static void reusableM2(Todo2 todo) {

    }

    private static void reusableM3(Function<String, String> todo) {

    }
}

class TopLevelOuter {
    private static String staticState = "abc";
    private String instatnceState = "def";

    protected static class StaticNested {
        public void getStaticOuterState() {
            System.out.println(staticState);
        }
    }

    protected class Nested {
        public void getOuterState() {
            System.out.println(TopLevelOuter.this.instatnceState);
        }
    }

    public Object outerMethod() {
        class LocalNested {
            public void unuseful() { }

            @Override
            public String toString() {
                return "abcdef";
            }
        }

        return new LocalNested();
    }

    public Object outerMethod2() {
        int local = 0;
//        local = 1;
        return new Object() {
            @Override
            public String toString() {
                System.out.println(local);
                return "1234";
            }
        };
    }
}

interface Todo {
    String todo();
}

@FunctionalInterface
interface Todo2 {
    String todo(String arg);
}