package com.db.com.db.dal;

public class TickerNotFoundException extends Exception {
    public TickerNotFoundException(String ticker) {
        super(ticker);
    }
}
