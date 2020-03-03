package com.db;

import com.db.service.BuyOperationException;
import com.db.service.Controller;

import java.sql.SQLException;

/**
 * Class.
 */
public class ClientUI {
    /**
     * Method. <b>ffgdgdfgd</b>
     * @deprecated
     * @param args gdfghdkfjghdfkjghfdkjgh
     * @throws BuyOperationException
     * @throws SQLException
     * @since 2.1
     */
    public static void main(String[] args ) throws BuyOperationException, SQLException {
        //single-line comment
        Controller controller = new Controller();

        /*
        multi-line
        comment
         */
        controller.buy("GZP", 10);
    }
}
