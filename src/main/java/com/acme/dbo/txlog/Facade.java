package com.acme.dbo.txlog;

import java.util.Arrays;

public class Facade {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static final String ARRAY = "primitives array: ";
    public static final String MATRIX = "primitives matrix: ";
    public static final String MULTIMATRIX = "primitives multimatrix: ";
    public static int intAccum;
    public static String messageType;
    private static byte byteAccum;
    private static int stringAccum;
    private static String lastStringMessage;
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static void log(int message) {
        if (messageType == null) {
            assignValues(message);
        } else if (!messageType.equals("int")) {
            flush(messageType);
            assignValues(message);
        } else {
            if (message == Integer.MAX_VALUE) {
                flush(messageType);
                System.out.println(PRIMITIVE + message);
            } else if (Integer.MAX_VALUE - intAccum - message < 0) {
                flush(messageType);
                assignValues(message);
                ;
            } else {
                intAccum += message;
            }
        }
    }

    public static void log(byte message) {
        if (messageType == null) {
            assignValues(message);
        } else if (!messageType.equals("byte")) {
            flush(messageType);
            assignValues(message);
        } else {
            if (message == Byte.MAX_VALUE) {
                flush(messageType);
                System.out.println(PRIMITIVE + message);
            } else if (Byte.MAX_VALUE - byteAccum - message < 0) {
                flush(messageType);
                byteAccum = message;
            } else {
                byteAccum += message;
            }
        }
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }

    public static void log(String message) {
        if (messageType == null) {
            assignValues(message);
        } else if (!messageType.equals("String")) {
            flush(messageType);
            assignValues(message);
        } else {
            if (lastStringMessage.equals(message)) {
                stringAccum += 1;
            } else {
                flush(messageType);
                assignValues(message);
            }
        }
    }

    public static void log(String... messages) {
        for (String message : messages) log(message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE + message);
    }

    public static void log(int[] message) {
        StringBuilder stringArray = new StringBuilder("{");
        for (int i = 0; i < message.length; i++) {
            if (i == (message.length - 1)) {
                stringArray.append(Integer.toString(message[i]) + '}');
                System.out.println(ARRAY + stringArray);
            } else {
                stringArray.append(Integer.toString(message[i]) + ", ");
            }
        }
    }

    public static void log(int[][] message) {
        StringBuilder stringMatrix = new StringBuilder("{" + System.lineSeparator());
        for (int i = 0; i < message.length; i++) {
            if (i == (message.length - 1)) {
                stringMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + System.lineSeparator() + "}");
                System.out.println(MATRIX + stringMatrix);
            } else {
                stringMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + System.lineSeparator());
            }
        }
    }

    public static void log(int[][][][] message) {
        StringBuilder stringMultiMatrix = new StringBuilder("{" + LINE_SEPARATOR);
        multiMatrixLog(message, stringMultiMatrix);
        System.out.println(MULTIMATRIX + stringMultiMatrix);
    }

    private static void multiMatrixLog(int[][][][] message, StringBuilder stringMultiMatrix) {
        if (message.length > 1) {
            for (int i = 0; i < message.length; i++) {
                if (i == (message.length - 1)) {
                    stringMultiMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR + "}");
                    System.out.println(MULTIMATRIX + stringMultiMatrix);
                } else {
                    stringMultiMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR);
                }
            }
        } else {
            stringMultiMatrix.append("{" + LINE_SEPARATOR);
            if (message[0].length > 1) {
                for (int i = 0; i < message[0].length; i++) {
                    if (i == (message.length - 1)) {
                        stringMultiMatrix.append("{" + Arrays.toString(message[0][i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR + "}");
                        System.out.println(MULTIMATRIX + stringMultiMatrix);
                    } else {
                        stringMultiMatrix.append("{" + Arrays.toString(message[0][i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR);
                    }
                }
            } else {
                stringMultiMatrix.append("{" + LINE_SEPARATOR);
                if (message[0][0].length > 1) {
                    for (int i = 0; i < message[0][0].length; i++) {
                        if (i == (message.length - 1)) {
                            stringMultiMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR + "}");
                            System.out.println(MULTIMATRIX + stringMultiMatrix);
                        } else {
                            stringMultiMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR);
                        }
                    }
                } else {
                    stringMultiMatrix.append("{" + LINE_SEPARATOR);
                    if (message[0][0][0].length > 1) {
                        for (int i = 0; i < message[0][0].length; i++) {
                            if (i == (message.length - 1)) {
                                stringMultiMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR + "}");
                                System.out.println(MULTIMATRIX + stringMultiMatrix);
                            } else {
                                stringMultiMatrix.append("{" + Arrays.toString(message[i]).substring(1, Arrays.toString(message[i]).length() - 1) + "}" + LINE_SEPARATOR);
                            }
                        }
                    } else {
                        stringMultiMatrix.append(Arrays.toString(message[0][0][0]).substring(1, Arrays.toString(message[0][0][0]).length() - 1) + LINE_SEPARATOR + "}" + LINE_SEPARATOR + "}" + LINE_SEPARATOR + "}" + LINE_SEPARATOR + "}");
                    }

                }

            }
        }
    }


    public static void flush(String messageType) {
        switch (messageType) {
            case "int":
                System.out.println(PRIMITIVE + intAccum);
                intAccum = 0;
                break;
            case "String":
                if (stringAccum == 1) {
                    System.out.println(STRING + lastStringMessage);
                    stringAccum = 0;
                } else if (stringAccum > 1) {
                    System.out.println(STRING + lastStringMessage + " (x" + stringAccum + ")");
                    stringAccum = 0;
                }
                break;
            case "byte":
                System.out.println(PRIMITIVE + byteAccum);
                byteAccum = 0;
                break;
        }
        Facade.messageType = null;
    }

    public static void clear() {
        flush(messageType);
        messageType = null;
    }

    private static void assignValues(int message) {
        messageType = "int";
        intAccum = message;
    }

    private static void assignValues(byte message) {
        messageType = "byte";
        byteAccum = message;
    }

    private static void assignValues(String message) {
        messageType = "String";
        stringAccum = 1;
        lastStringMessage = message;
    }
}
