package eappdemo;

/**
 * API: CRUD
 */
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Config: external xml | @GetRequest("/path")
    public void findAccountById(FindRequest request) {
        int i = 0;
        if (request.getId() == null) throw new IllegalArgumentException("id null");
        if (request.getId() < 0) throw new IllegalArgumentException("id negative");
        accountService.findById();
    }
}
