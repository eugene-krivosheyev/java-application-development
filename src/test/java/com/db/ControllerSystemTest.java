package com.db;

import com.db.service.BuyOperationException;
import com.db.service.Controller;
import com.db.service.SellOperationException;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ControllerSystemTest {
    private Controller controller = new Controller();

    @Before
    public void setUp() {

    }

    @Test
    public void shouldDoBuyForOneLotOfExistTicker() throws SQLException, BuyOperationException {
        assertEquals(1.0, controller.buy("TKRGZP", 1), 0.01);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void shouldGetErrorWhenSellZeroLot() throws SQLException, BuyOperationException, SellOperationException {
        controller.sell("TKR", 0);
    }
}
