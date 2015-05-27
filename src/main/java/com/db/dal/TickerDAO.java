package com.db.dal;

import com.db.domain.Ticker;

import java.sql.SQLException;

public class TickerDAO {
    public Ticker getTicker(String tickerId) throws TickerNotFoundException {
        if(!tickerId.contains("TKR")) throw new TickerNotFoundException(tickerId);
        return new Ticker(tickerId);
    }

    public void openConnection(String connection) throws SQLException {
        if(!connection.contains("jdbc:")) throw new SQLException("Wrong connection string: " + connection);
    }

    public void close() throws SQLException {

    }
}
