package com.acme.dbo.txlog.writers;

public interface Writer  {
    void write(String message) throws WriteException;
}
