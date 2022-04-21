package com.acme.dbo.txlog.decorator;

import static java.lang.System.lineSeparator;

public class MessageDecorator {

    private static final String MESSAGE_PREFIX_PRIMITIVE = "primitive: ";
    private static final String MESSAGE_PREFIX_CHAR = "char: ";
    private static final String MESSAGE_PREFIX_STRING = "string: ";
    private static final String MESSAGE_PREFIX_REFERENCE = "reference: ";

    private static final String JAVA_LANG_INTEGER = "java.lang.Integer";
    private static final String JAVA_LANG_BOOLEAN = "java.lang.Boolean";
    private static final String JAVA_LANG_BYTE = "java.lang.Byte";
    private static final String JAVA_LANG_CHARACTER = "java.lang.Character";
    private static final String JAVA_LANG_STRING = "java.lang.String";
    private static final String JAVA_LANG_OBJECT = "java.lang.Object";

    private static final String EMPTY_OBJECT = "FORCE_STOP";
    private static final String STRING_EMPTY = "";

    private static int INT_MEMORY = 0;

    private static int STRING_MEMORY_COUNT = 0;
    private static String STRING_MEMORY = "";

    private static String PREVIOUS_JAVA_LANG_TYPE = "";
    private static String CONCATENATED_LOGGER_CONTENT = "";


    public static String getLoggerContent() {
        appendLogValue(null, EMPTY_OBJECT);
        String loggerContent = CONCATENATED_LOGGER_CONTENT;
        clearMemoryLoggerContent();
        clearMemoryInt();
        clearMemoryString();
        return loggerContent;
    }

    public static void appendLogValue(Object obj) {
        appendLogValue(obj, obj.getClass().getName());
    }

    private static void appendLogValue(Object obj, String currentLogObjType) {

        if (PREVIOUS_JAVA_LANG_TYPE.equals(JAVA_LANG_INTEGER) & !currentLogObjType.equals(JAVA_LANG_INTEGER)) {
            appendIntegerLogLine();
            clearMemoryInt();
        }

        if (PREVIOUS_JAVA_LANG_TYPE.equals(JAVA_LANG_BYTE) & !currentLogObjType.equals(JAVA_LANG_BYTE)) {
            appendIntegerLogLine();
            clearMemoryInt();
        }

        if ( (PREVIOUS_JAVA_LANG_TYPE.equals(JAVA_LANG_STRING) & !currentLogObjType.equals(JAVA_LANG_STRING)) ||
             (PREVIOUS_JAVA_LANG_TYPE.equals(JAVA_LANG_STRING) & currentLogObjType.equals(JAVA_LANG_STRING) && !STRING_MEMORY.equals(obj.toString()))) {
            appendStringLogLine();
            clearMemoryString();
        }

        PREVIOUS_JAVA_LANG_TYPE = currentLogObjType;

        switch (currentLogObjType)
        {
            case JAVA_LANG_INTEGER:
                memoriseNewIntegerOrOverflowString((int)obj);
                break;
            case JAVA_LANG_BYTE:
                memoriseNewByteOrOverflowString((byte)obj);
                break;
            case JAVA_LANG_STRING:
                memoriseNewString(obj.toString());
                break;
            case EMPTY_OBJECT:
                break;
            default:
                appendCommonLogLine(obj);
        }
    }

    private static void memoriseNewString(String string) {
        STRING_MEMORY_COUNT++;
        STRING_MEMORY = string;
    }

    private static void memoriseNewIntegerOrOverflowString(int newNumber) {
        if (INT_MEMORY > 0 && newNumber > Integer.MAX_VALUE - INT_MEMORY) {
            PREVIOUS_JAVA_LANG_TYPE = JAVA_LANG_STRING;
            memoriseNewString("Integer.MAX_VALUE");
        } else if (INT_MEMORY < 0 && newNumber < Integer.MIN_VALUE - INT_MEMORY) {
            PREVIOUS_JAVA_LANG_TYPE = JAVA_LANG_STRING;
            memoriseNewString("Integer.MIN_VALUE");
        }
        else INT_MEMORY = INT_MEMORY + newNumber;
    }

    private static void memoriseNewByteOrOverflowString(byte newNumber) {
        if (INT_MEMORY > 0 && newNumber > Byte.MAX_VALUE - INT_MEMORY) {
            PREVIOUS_JAVA_LANG_TYPE = JAVA_LANG_STRING;
            memoriseNewString("Byte.MAX_VALUE");
        } else if (INT_MEMORY < 0 && newNumber < Byte.MIN_VALUE - INT_MEMORY) {
            PREVIOUS_JAVA_LANG_TYPE = JAVA_LANG_STRING;
            memoriseNewString("Byte.MIN_VALUE");
        }
        else INT_MEMORY = INT_MEMORY + newNumber;
    }

    private static void appendStringLogLine() {
        final String formatCounterPostfix = " (x%s)";
        String formatPostfix = "";
        if (STRING_MEMORY_COUNT > 1) {
            formatPostfix = String.format(formatCounterPostfix, STRING_MEMORY_COUNT);
        }
        appendLogLine(getPrefix(STRING_MEMORY) + STRING_MEMORY + formatPostfix);
    }

    private static void appendIntegerLogLine() {
        appendLogLine(getPrefix(INT_MEMORY) + INT_MEMORY);
    }

    private static void appendCommonLogLine(Object obj) {
        appendLogLine(getPrefix(obj) + obj.toString());
    }

    private static void appendLogLine(String message) {
        CONCATENATED_LOGGER_CONTENT = CONCATENATED_LOGGER_CONTENT + message + lineSeparator();
    }

    private static String getPrefix(Object obj) {
        switch (obj.getClass().getName())
        {
            case JAVA_LANG_INTEGER:
            case JAVA_LANG_BOOLEAN:
            case JAVA_LANG_BYTE:
                return MESSAGE_PREFIX_PRIMITIVE;
            case JAVA_LANG_CHARACTER:
                return MESSAGE_PREFIX_CHAR;
            case JAVA_LANG_STRING:
                return MESSAGE_PREFIX_STRING;
            case JAVA_LANG_OBJECT:
                return MESSAGE_PREFIX_REFERENCE;
            default:
                return STRING_EMPTY;
        }
    }

    private static void clearMemoryLoggerContent() {
        CONCATENATED_LOGGER_CONTENT = "";
        PREVIOUS_JAVA_LANG_TYPE = "";
    }

    private static void clearMemoryString() {
        STRING_MEMORY = "";
        STRING_MEMORY_COUNT = 0;
    }

    private static void clearMemoryInt() {
        INT_MEMORY = 0;
    }
}