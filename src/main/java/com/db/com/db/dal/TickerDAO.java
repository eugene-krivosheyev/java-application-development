package com.db.com.db.dal;

import com.db.domain.Ticker;

public class TickerDAO {
    public Ticker getTicker(String ticker) throws TickerNotFoundException {
        throw new TickerNotFoundException(ticker);
    }
}
