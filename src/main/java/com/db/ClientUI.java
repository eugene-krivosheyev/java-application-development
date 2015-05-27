package com.db;

import com.db.service.BuyOperationException;
import com.db.service.Controller;

import java.sql.SQLException;

public class ClientUI {
    public static void main(String[] args ) throws BuyOperationException, SQLException {
        Controller controller = new Controller();
        controller.buy("GZP", 10);
    }
}
