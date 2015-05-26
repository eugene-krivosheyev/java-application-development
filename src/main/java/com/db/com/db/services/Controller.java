package com.db.com.db.services;

import com.db.com.db.dal.Stock;
import com.db.com.db.dal.TickerDAO;
import com.db.com.db.dal.TickerNotFoundException;
import com.db.domain.Ticker;

public class Controller {
    private TickerDAO tickerDAO = new TickerDAO();
    private Stock stock = new Stock();

    public void buy(String ticker, int amount) throws BuyOperationException {
        final int BUY_OPERATION = 1;
        Ticker tickerObject = null;

        try {
            tickerObject = tickerDAO.getTicker(ticker);
        } catch (TickerNotFoundException e) {
            throw new BuyOperationException(e, "");
        } finally {
            //Maybe suppression
        }

        stock.order(tickerObject.toString(), amount, BUY_OPERATION);
    }
}
