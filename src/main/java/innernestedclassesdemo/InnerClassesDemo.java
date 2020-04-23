package innernestedclassesdemo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer.StaticInner object = new Outer.StaticInner();
        object.doSmth();
    }
}

class Outer {
    private int objectState;
    private static int classSate = 1;

    protected static class StaticInner {
       private int innerObjectSatate;
       private static int innStaticSate;

       public void doSmth() {
           System.out.println(classSate);
       }
    }
}
