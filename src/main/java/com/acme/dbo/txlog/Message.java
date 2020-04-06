package com.acme.dbo.txlog;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class Message {

    private MessageType messageType;
    private Object value;
    private String arrayValue;

    private Message(MessageType messageType, Object value) {
        this.messageType = messageType;
        this.value = value;
    }

    public Message(int value) {
        this(MessageType.INT, value);
    }

    public Message(byte value) {
        this(MessageType.BYTE, value);
    }

    public Message(String value) {
        this(MessageType.STRING, value);
    }

    public Message(char value) {
        this(MessageType.CHAR, value);
    }

    public Message(boolean value) {
        this(MessageType.BOOLEAN, value);
    }

    public Message(int[][][][] value) {
        this(MessageType.PRIMITIVE_MULTIMATRIX, value);
        arrayValue = getStringForArray(Arrays.deepToString(value));
    }

    public Message(int[][] value) {
        this(MessageType.PRIMITIVE_MATRIX, value);
        arrayValue = getStringForArray(Arrays.deepToString(value));
    }

    public Message(int[] value) {
        this(MessageType.PRIMITIVE_ARRAY, value);
        arrayValue = getStringForArray(Arrays.toString(value));
    }

    public Message(Object value) {
        this(MessageType.OBJECT, value);
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getValue() {
        if (messageType == MessageType.PRIMITIVE_ARRAY || messageType == MessageType.PRIMITIVE_MATRIX
                || messageType == MessageType.PRIMITIVE_MULTIMATRIX) {
            return arrayValue;
        }
        return (value == null) ? null : value.toString();
    }

    public int getIntValue() {
        if (messageType != MessageType.INT) {
            throw new IncompatibleValueException("Requested for not integer value");
        }
        return (Integer) value;
    }

    public byte getByteValue() {
        if (messageType != MessageType.BYTE) {
            throw new IncompatibleValueException("Requested for not integer value");
        }
        return (Byte) value;
    }

    private String getStringForArray(String arrayString) {
        String resultString = arrayString
                .replace("[", "{")
                .replace("]", "}")
                .replace("}, {", "}" + lineSeparator() + "{");

        while (resultString.contains("{{") || resultString.contains("}}")) {
            resultString = resultString.replace("{{", "{" + lineSeparator() + "{")
                    .replace("}}", "}" + lineSeparator() + "}");
        }

        resultString = resultString.replaceAll("\\{(\\d+)}", "{" + lineSeparator() + "$1" + lineSeparator() + "}");

        return resultString;
    }
}