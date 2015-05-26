package com.db;

import com.db.com.db.services.BuyOperationException;
import com.db.com.db.services.Controller;

public class ClientUI {
    public static void main(String[] args ) throws BuyOperationException {
        Controller controller = new Controller();
        controller.buy("GZP", 10);
    }
}
