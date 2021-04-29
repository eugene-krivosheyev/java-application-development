package eappdemo;

/**
 * API: CRUD
 */
public class AccountController {
    private AccountService accountService;
    volatile int counter = 0;
    private Object monitor = new Object();

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Config: external xml | @GetRequest("/path")
    public void findAccountById(FindRequest request) {
        synchronized (monitor) { //Lock -> ReadWriteLock
            counter++; //1,2,3
        } // -> AtomicXXX: non-blocking

        if (counter == 5) counter = 0;

        int i = 0;
        if (request.getId() == null) throw new IllegalArgumentException("id null");
        if (request.getId() < 0) throw new IllegalArgumentException("id negative");
        accountService.findById();
    }
}
