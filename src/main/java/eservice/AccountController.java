package eservice;

import java.util.ArrayList;
import java.util.List;

//@Controller("/api")
public class AccountController {
    private volatile int counter = 0; //data race | visibility (JMM)
    private AccountService accountService;
    List list = new ArrayList<>();

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @GetRequest("/account/{id}")
    public synchronized Account findAccountById(Integer id) {
        synchronized (this) { // -> ReadWriteLock
            counter++; // data race + visibility
            list.add("some");
        } // -> AtomicXXX.incAndGet | non-blocking CAS

        if (counter == 0) counter = 5;

        int localVar = 5;
        if (id == null) throw new IllegalArgumentException("id null");
        if (id < 0) throw new IllegalArgumentException("id negative!!");

//        obj.m();
//        Thread.sleep();
//        io.read();

        return accountService.findById(id);
    }
}
