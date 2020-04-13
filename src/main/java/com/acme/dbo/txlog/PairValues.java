package com.acme.dbo.txlog;

public class PairValues {
    private Integer integer;
    private String string;

    PairValues(String string, Integer integer) {
        this.integer = integer;
        this.string = string;
    }

    Integer getInteger() {
        return integer;
    }

    String getString() {
        return string;
    }
}
