package com.db.service;

import com.db.dal.TickerNotFoundException;

public class BuyOperationException extends Exception {
    public BuyOperationException(TickerNotFoundException e, String s) {
        super(s, e);
    }
}
