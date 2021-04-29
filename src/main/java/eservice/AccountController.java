package eservice;

//@Controller("/api")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @GetRequest("/account/{id}")
    public Account findAccountById(Integer id) {
        return null;
    }
}
