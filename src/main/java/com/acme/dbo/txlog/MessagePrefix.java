package com.acme.dbo.txlog;

public enum MessagePrefix {
    PRIMITIVE("primitive: "),
    CHAR("char: "),
    REFERENCE("reference: "),
    STRING("string: "),
    PRIMITIVES_ARRAY("primitives array: "),
    PRIMITIVES_MATRIX("primitives matrix: "),
    PRIMITIVES_MULTIMATRIX("primitives multimatrix: ");

    private String messagePrefix;
    MessagePrefix(String prefix) {
        this.messagePrefix = prefix;
    }

    public String getMessagePrefix() {
        return messagePrefix;
    }
}
