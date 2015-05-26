package com.db;

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