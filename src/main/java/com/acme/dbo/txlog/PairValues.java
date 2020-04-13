package com.acme.dbo.txlog;

public class PairValues {
    private Integer integer;
    private String string;

    public PairValues(String string,Integer integer) {
        this.integer = integer;
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }
}
