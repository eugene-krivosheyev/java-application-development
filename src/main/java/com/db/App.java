package com.db;

public class App {
    public static void main(String[] args ) {
        Deal deal = new Deal();
        deal.setName("field value for name");
    }
}

class Deal {
    private int id;
    private String name;
    private Deal nextDeal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int localVar;
        this.name = name;
    }
}
