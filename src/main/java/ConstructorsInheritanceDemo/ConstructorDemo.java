package ConstructorsInheritanceDemo;

import java.util.ArrayList;
import java.util.List;

public class ConstructorDemo {
    public static void main(String[] args) {
        List list = new ArrayList() {{ add(1); add(1);  }};

    }
}


//POJO
class Human {
    private String name;
    private String workAddress;

    Human(String name, String workAddress) {
        this.name = name;
        this.workAddress = workAddress;
    }

    public String getName() {
        return name;
    }

    public String getWorkAddress() {
        return workAddress;
    }
}

class RichHuman extends Human {
    {
        System.out.println("fff");
    }


    RichHuman(String name) {
        super("Sir " + name, "home 1pm - 2pm");

    }

    public String getAccountState() throws IllegalBankAccountQuestion {
        throw new IllegalBankAccountQuestion("jghdfjdh");
    }

//    @Override
    public String getWorkAddress() {
        return super.getWorkAddress() + " с 12:00 до 12:30";
    }
}




class IllegalBankAccountQuestion extends Exception {
    private int field ;

    public IllegalBankAccountQuestion() {
//        super(); // XOR
        this("");
        this.field = 6;
        //super();
        //....
        //super();
        ////...

        //this() VS super()
    }

    public IllegalBankAccountQuestion(String message) {
        super(message);
    }

    public IllegalBankAccountQuestion(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalBankAccountQuestion(Throwable cause) {
        super(cause);
    }

    protected IllegalBankAccountQuestion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
