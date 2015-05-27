package com.db.domain;

public class Ticker {
    private String tickerId;

    public Ticker(String tickerId) {
        this.tickerId = tickerId;
    }

    public String getTickerId() {
        return tickerId;
    }
}
