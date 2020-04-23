package innernestedclassesdemo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
    }
}

class Outer {
    private static int classSate = 1;
    private int objectState = 1;

    protected class Inner {
       private int innerObjectSatate;
//       private static int innStaticSate;

       public void doSmth() {
           System.out.println(classSate);
           System.out.println(Outer.this.objectState);
       }
    }
}
