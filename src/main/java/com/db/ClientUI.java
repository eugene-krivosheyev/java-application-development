package com.db;

import com.db.service.BuyOperationException;
import com.db.service.Controller;

import java.sql.SQLException;

/**
 * Text.
 * @author
 * @since 1.4
 */
public class ClientUI {
    /**
     * Method info.
     * @param args Why?
     * @return what??
     * @throws BuyOperationException
     * @throws SQLException
     * @since 1.4
     */
    public static void main(String[] args) throws BuyOperationException, SQLException {
        Controller controller = new Controller();
        controller.buy("GZP", 10);

        System.out.println();
    }
}
