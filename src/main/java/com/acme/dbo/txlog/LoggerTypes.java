package com.acme.dbo.txlog;

public enum LoggerTypes {

    INT_TYPE("primitive", true),
    BYTE_TYPE("primitive", true),
    BOOLEAN_TYPE("primitive", false),
    OBJECT_TYPE("reference", false),
    CHAR_TYPE("char", false),
    STRING_TYPE("string", true);

    private String decoratePrefix;
    private boolean isBuffered;

    LoggerTypes(String decoratePrefix, boolean isBuffered) {
        this.decoratePrefix = decoratePrefix;
        this.isBuffered = isBuffered;
    }

    public boolean isBuffered(){
        return isBuffered;
    }

    public String getDecoratePrefix() {
        return decoratePrefix;
    }
}
