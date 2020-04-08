package com.acme.dbo.txlog;

import javafx.util.Pair;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Controller {

    private static Integer integerAccumulator;
    private static Integer integerSum;
    private static Byte byteAccumulator;
    private static Boolean booleanAccumulator;
    private static String charAccumulator;
    private static String stringAccumulator;
    private static String objectAccumulator;
    private static String lastString;
    private static Integer duplicateStringCount;
    private static String arrayAccumulator;
    private static String matrixAccumulator;
    private static String multiMatrixAccumulator;
    private static String varArgsAccumulator;
    private static String lastCommandType;
    private static Integer duplicateCharCount;
    private static Integer duplicateArrayCount;
    private static Integer duplicateMatrixCount;
    private static Integer duplicateMultiMatrixCount;
    private static Integer duplicateVarArgsCount;
    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String INTEGER_DECOR = PRIMITIVE_DECOR;
    private static String BYTE_DECOR = PRIMITIVE_DECOR;
    private static String CHAR_DECOR = "char: ";
    private static String STRING_DECOR = "string: ";
    private static String REFERENCE_DECOR = "reference: ";
    private static String ARRAY_DECOR = "primitives array: ";
    private static String MATRIX_DECOR = "primitives matrix: ";
    private static String MULTI_MATRIX_DECOR = "primitives multimatrix: ";

    public static void logInteger(int message, boolean isDecorated) {
        flushLastState(isDecorated, "Byte", "String");

        if (checkIntegerValueIsOutBound(message)) {
            flushLastState(isDecorated, "Integer");
            integerAccumulator = Integer.MAX_VALUE;
            integerSum = Integer.MAX_VALUE;
            flushLastState(isDecorated, "Integer");
        } else {
            if (integerAccumulator == null) {
                integerAccumulator = message;
                integerSum = message;
            } else {
                integerAccumulator = integerAccumulator + message;
                integerSum = integerSum + message;
            }

        }
        lastCommandType = "Integer";
    }


    public static void logBoolean(boolean message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String");

        String msg = String.valueOf(message);
        writeFormattedLog(PRIMITIVE_DECOR, msg, isDecorated);
        lastCommandType = "Boolean";
    }

    public static void logByte(byte message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "String");

        if (checkByteValueIsOutBound(message)) {
            flushLastState(isDecorated, "Byte");
            byteAccumulator = Byte.MAX_VALUE;
            flushLastState(isDecorated, "Byte");
        } else {
            String msg = String.valueOf(message);
            writeFormattedLog(BYTE_DECOR, msg, isDecorated);
        }
        lastCommandType = "Byte";
    }

    public static void logChar(char message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String");

        String msg = String.valueOf(message);
        writeFormattedLog(CHAR_DECOR, msg, isDecorated);
        lastCommandType = "Char";
    }

    public static void log(String message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");

//        accumulateObjectDuplicates(message,stringAccumulator,duplicateStringCount,lastString);

        if (stringAccumulator == null) {
            stringAccumulator = message;
            duplicateStringCount = 1;
        } else {
            if (message.equals(lastString)) {
                duplicateStringCount++;
            } else {
                if (duplicateStringCount >= 2) {
                    stringAccumulator = stringAccumulator + " (x" + duplicateStringCount + ")";
                }
                stringAccumulator = stringAccumulator + System.lineSeparator() + STRING_DECOR + message;
                duplicateStringCount = 1;
            }

        }
        lastString = message;
        lastCommandType = "String";
    }


    public static void log(Object message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String");

        System.out.println(REFERENCE_DECOR + message);
        lastCommandType = "Object";
    }

    public static void log(int[] ints, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");
        Pair<String, Integer> accumulatedPair = accumulateArrays(arrayAccumulator, duplicateArrayCount, Arrays.toString(ints));
        arrayAccumulator = accumulatedPair.getKey();
        duplicateArrayCount = accumulatedPair.getValue();
        lastCommandType = "Array";
    }

    public static void log(int[][] ints, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");
        Pair<String, Integer> accumulatedPair = accumulateArrays(matrixAccumulator, duplicateMatrixCount, Arrays.deepToString(ints));
        matrixAccumulator = accumulatedPair.getKey();
        duplicateMatrixCount = accumulatedPair.getValue();
        lastCommandType = "Matrix";
    }

    public static void log(int[][][][] ints, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");
        Pair<String, Integer> accumulatedPair = accumulateArrays(multiMatrixAccumulator, duplicateMultiMatrixCount, Arrays.deepToString(ints));
        multiMatrixAccumulator = accumulatedPair.getKey();
        duplicateMultiMatrixCount = accumulatedPair.getValue();
        lastCommandType = "MultiMatrix";
    }

    public static void log(boolean isDecorated, String... strings) {
        flushLastState(isDecorated, "Integer", "Byte");
        for (String current : strings) {
            Pair<String, Integer> accumulatedPair = accumulateArrays(varArgsAccumulator, duplicateVarArgsCount, current);
            varArgsAccumulator = accumulatedPair.getKey();
            duplicateVarArgsCount = accumulatedPair.getValue();
        }
        lastCommandType = "StringVarargs";
    }

    public static void flush(boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String", "Array", "Matrix", "MultiMatrix", "StringVarargs");
    }

    private static void writeFormattedLog(String decoration, Object message, boolean isDecorated) {
        if (isDecorated) {
            writeOutput(decoration + message);
        } else {
            writeOutput(message);
        }
    }

    private static void writeOutput(Object msg) {
        System.out.println(msg);
    }

    public static void flushLastState(boolean isDecorated, String... types) {
        for (String current : types) {
            if (current.equals("Integer")) {
                flushLastIntegerState(isDecorated);
            }
            if (current.equals("Byte")) {
                flushLastByteState(isDecorated);
            }
            if (current.equals("Boolean")) {
                flushLastBooleanState(isDecorated);
            }
            if (current.equals("Char")) {
                flushLastStringLikeAccumulatorState("Char", isDecorated);
            }
            if (current.equals("String")) {
                flushLastStringLikeAccumulatorState("String", isDecorated);
            }
            if (current.equals("Array")) {
                flushLastStringLikeAccumulatorState("Array", isDecorated);
            }
            if (current.equals("Matrix")) {
                flushLastStringLikeAccumulatorState("Matrix", isDecorated);
            }
            if (current.equals("MultiMatrix")) {
                flushLastStringLikeAccumulatorState("MultiMatrix", isDecorated);
            }
            if (current.equals("StringVarargs")) {
                flushLastStringLikeAccumulatorState("StringVarargs", isDecorated);
            }
        }
    }


    private static void flushLastIntegerState(boolean isDecorated) {
        if (integerAccumulator != null) {
            writeFormattedLog(INTEGER_DECOR, integerAccumulator, isDecorated);
        }
        integerAccumulator = null;
    }

    private static void flushLastByteState(boolean isDecorated) {
        if (byteAccumulator != null) {
            writeFormattedLog(BYTE_DECOR, byteAccumulator, isDecorated);
        }
        byteAccumulator = null;
    }

    private static void flushLastBooleanState(boolean isDecorated) {
        if (booleanAccumulator != null) {
            writeFormattedLog(BYTE_DECOR, booleanAccumulator, isDecorated);
        }
        booleanAccumulator = null;
    }

    private static void flushLastStringLikeAccumulatorState(String objectType, boolean isDecorated) {
        if (objectType != null) {
            if (objectType.equals("String")) {
                stringAccumulator = flushLastStringObjectState(stringAccumulator, duplicateStringCount, STRING_DECOR, isDecorated);
            }
            if (objectType.equals("Char")) {
                charAccumulator = flushLastStringObjectState(charAccumulator, duplicateCharCount, CHAR_DECOR, isDecorated);
            }
            if (objectType.equals("Array")) {
                if (arrayAccumulator != null) {
                    arrayAccumulator = convertStraightBracketsToCurly(arrayAccumulator);
                }
                arrayAccumulator = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, ARRAY_DECOR, isDecorated);
            }
            if (objectType.equals("Matrix")) {
                if (matrixAccumulator != null) {
                    matrixAccumulator = convertStraightBracketsToCurly(matrixAccumulator);
                }
                matrixAccumulator = flushLastStringObjectState(matrixAccumulator, duplicateMatrixCount, MATRIX_DECOR, isDecorated);
            }
            if (objectType.equals("MultiMatrix")) {
                if (multiMatrixAccumulator != null) {
                    multiMatrixAccumulator = multiMatrixAccumulator.replace("[", "{\n").replace("]", "\n}");
                }
                multiMatrixAccumulator = flushLastStringObjectState(multiMatrixAccumulator, duplicateMultiMatrixCount, MULTI_MATRIX_DECOR, isDecorated);
            }
            if (objectType.equals("StringVarargs")) {
                varArgsAccumulator = flushLastStringObjectState(varArgsAccumulator, duplicateVarArgsCount, STRING_DECOR, isDecorated);
            }
        }
    }

    private static String flushLastStringObjectState(String arrayType, Integer duplicateCount, String decoration, boolean isDecorated) {
        if (arrayType != null) {
            if (duplicateCount >= 2) {
                arrayType = arrayType + " (x" + duplicateCount + ")";
            }
            writeFormattedLog(decoration, arrayType, isDecorated);
        }
        return null;
    }

    public static Pair<String, Integer> accumulateArrays(String arrayAccumulator, Integer duplicateObjectCount, String stringArray) {
        if (arrayAccumulator == null) {
            arrayAccumulator = stringArray;
            duplicateObjectCount = 1;
        } else {
            arrayAccumulator = arrayAccumulator + System.lineSeparator() + stringArray;
            duplicateObjectCount++;
        }
        return new Pair<String, Integer>(arrayAccumulator, duplicateObjectCount);
    }

    private static String convertStraightBracketsToCurly(String text) {
        text = text.replace("[", "{").replace("]", "}");
        while (text.contains("{{") == true) {
            text = text.replace("{{", "{\n{").replace("}}", "}\n}");
        }
        return text.replace("}, ", "}\n");
    }

    private static boolean checkIntegerValueIsOutBound(Integer number) {
        long longValue = (long) number;
        if (abs(longValue) >= Integer.MAX_VALUE) {
            return true;
        } else return false;
    }

    private static boolean checkByteValueIsOutBound(Byte number) {
        short shortValue = (short) number;
        if (abs(shortValue) >= Byte.MAX_VALUE) {
            return true;
        } else return false;
    }
}