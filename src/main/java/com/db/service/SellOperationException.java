package com.db.service;

import com.db.dal.TickerNotFoundException;

public class SellOperationException extends Throwable {
    public SellOperationException(TickerNotFoundException e, String s) {
        super(s, e);
    }
}
