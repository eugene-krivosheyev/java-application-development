package com.db.com.db.services;

import com.db.com.db.dal.TickerNotFoundException;

/**
 * Created by eugene on 26.05.15.
 */
public class BuyOperationException extends Exception {
    public BuyOperationException(TickerNotFoundException e, String s) {
        super(s, e);
    }
}
