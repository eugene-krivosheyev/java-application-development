package com.db.service;

import com.db.domain.StockDAO;
import com.db.dal.TickerDAO;
import com.db.dal.TickerNotFoundException;
import com.db.domain.Ticker;

import java.sql.SQLException;

public class Controller {
    private TickerDAO tickerDAO = new TickerDAO();
    private StockDAO stock = new StockDAO();

    public double buy(String tickerId, int amount) throws BuyOperationException, SQLException {
        final int BUY_OPERATION = 1;
        Ticker tickerObject = null;

        try {
            tickerDAO.openConnection("jdbc:oracle:myhost");
            tickerObject = tickerDAO.getTicker(tickerId);
        } catch (TickerNotFoundException e) {
            throw new BuyOperationException(e, "");
        } finally {
            tickerDAO.close();
        }

        return stock.placeOrder(tickerObject.toString(), amount, BUY_OPERATION);
    }

    public double sell(String tickerId, int amount) throws SellOperationException, SQLException {
        final int SELL_OPERATION = 2;
        Ticker tickerObject = null;

        try {
            tickerDAO.openConnection("jdbc:oracle:myhost");
            tickerObject = tickerDAO.getTicker(tickerId);
        } catch (TickerNotFoundException e) {
            throw new SellOperationException(e, "");
        } finally {
            tickerDAO.close();
        }

        return stock.placeOrder(tickerId, amount, SELL_OPERATION);
    }
}
