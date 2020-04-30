package lambdademo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class LDEmo {
    public static void main(String[] args) {
//        String result =  patternMethod("toLowerCa");
        ToDoDo result = patternMethod(s -> s.toLowerCase());
        result.execute("?????");
    }

    public static ToDoDo patternMethod(ToDoDo todo) {
        //.....
        //.....
        todo.execute("a");
        //....
        //....
        return p -> System.out.println(">>>" + p);
    }
}

@FunctionalInterface
interface ToDoDo {
    void execute(String p);
}
