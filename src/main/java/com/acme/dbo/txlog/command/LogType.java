package com.acme.dbo.txlog.command;

enum LogType {
    INT("primitive"), BOOL("primitive"), BYTE("primitive"),
    CHAR("char"), STR("string"), OBJ("reference"),
    MATRIX("primitives matrix"), MULTIMATRIX("primitives multimatrix");

    private String prefix;

    LogType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
