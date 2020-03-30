package com.acme.dbo.txlog;

import javafx.util.Pair;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Facade {
    private static Integer integerAccumulator;
    private static Byte byteAccumulator;
    private static String stringAccumulator;
    private static String lastString;
    private static Integer duplicateStringCount;
    private static String arrayAccumulator;
    private static String dimensionType;
    private static Integer duplicateArrayCount;
    private static Integer duplicateMatrixCount;
    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String INTEGER_DECOR = PRIMITIVE_DECOR;
    private static String BYTE_DECOR = PRIMITIVE_DECOR;
    private static String CHAR_DECOR = "char: ";
    private static String STRING_DECOR = "string: ";
    private static String REFERENCE_DECOR = "reference: ";
    private static String ARRAY_DECOR = "primitives array: ";
    private static String MATRIX_DECOR = "primitives matrix: ";
    private static String MULTI_MATRIX_DECOR = "primitives multimatrix: ";


    public static void log(int message, boolean isDecorated) {
        flushLastState(isDecorated, "Byte", "String");

        if (Facade.checkIntegerValueIsOutBound(message)) {
            flushLastState(isDecorated, "Integer");
            integerAccumulator = Integer.MAX_VALUE;
            flushLastState(isDecorated, "Integer");
        } else {
            if (integerAccumulator == null) {
                integerAccumulator = message;
            } else {
                integerAccumulator = integerAccumulator + message;
            }

        }
    }


    public static void log(boolean message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String");

        String msg = String.valueOf(message);
        writeFormattedLog(PRIMITIVE_DECOR, msg, isDecorated);

    }

    public static void log(byte message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "String");

        if (checkByteValueIsOutBound(message)) {
            flushLastState(isDecorated, "Byte");
            byteAccumulator = Byte.MAX_VALUE;
            flushLastState(isDecorated, "Byte");
        } else {
            String msg = String.valueOf(message);
            writeFormattedLog(BYTE_DECOR, msg, isDecorated);
        }

    }

    public static void log(char message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String");

        String msg = String.valueOf(message);
        writeFormattedLog(CHAR_DECOR, msg, isDecorated);

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
                stringAccumulator = stringAccumulator + System.lineSeparator() + message;
                duplicateStringCount = 1;
            }

        }
        lastString = message;
    }


    public static void log(Object message, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String");

        System.out.println(REFERENCE_DECOR + message);
    }

    public static void log(int[] ints, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");
        Pair<String, Integer> accumulatedPair = accumulateArrays(arrayAccumulator, duplicateArrayCount, Arrays.toString(ints));
        arrayAccumulator = accumulatedPair.getKey();
        duplicateArrayCount = accumulatedPair.getValue();
        dimensionType = "Array";
    }

    public static void log(int[][] ints, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");
        Pair<String, Integer> accumulatedPair = accumulateArrays(arrayAccumulator, duplicateArrayCount, Arrays.deepToString(ints));
        arrayAccumulator = accumulatedPair.getKey();
        duplicateArrayCount = accumulatedPair.getValue();
        dimensionType = "Matrix";
    }

    public static void log(int[][][][] ints, boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte");
        Pair<String, Integer> accumulatedPair = accumulateArrays(arrayAccumulator, duplicateArrayCount, Arrays.deepToString(ints));
        arrayAccumulator = accumulatedPair.getKey();
        duplicateArrayCount = accumulatedPair.getValue();
        dimensionType = "MultiMatrix";
    }

    public static void log(boolean isDecorated, String... strings) {
        flushLastState(isDecorated, "Integer", "Byte");
        for (String current : strings) {
            Pair<String, Integer> accumulatedPair = accumulateArrays(arrayAccumulator, duplicateArrayCount, current);
            arrayAccumulator = accumulatedPair.getKey();
            duplicateArrayCount = accumulatedPair.getValue();
        }
        dimensionType = "StringVarargs";
    }

    public static void flush(boolean isDecorated) {
        flushLastState(isDecorated, "Integer", "Byte", "String", "Array", "Matrix", "MultiMatrix","StringVarargs");
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
            if (current.equals("String")) {
                flushLastObjectState("String", isDecorated);
            }
            if (dimensionType != null) {
                if (current.equals("Array") && (dimensionType.equals("Array"))) {
                    flushLastObjectState("Array", isDecorated);
                }
                if (current.equals("Matrix") && (dimensionType.equals("Matrix"))) {
                    flushLastObjectState("Matrix", isDecorated);
                }
                if (current.equals("MultiMatrix") && (dimensionType.equals("MultiMatrix"))) {
                    flushLastObjectState("MultiMatrix", isDecorated);
                }
                if (current.equals("StringVarargs") && (dimensionType.equals("StringVarargs"))) {
                    flushLastObjectState("StringVarargs", isDecorated);
                }
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

    private static void flushLastObjectState(String objectType, boolean isDecorated) {
        if (objectType != null) {
            if (objectType.equals("String")) {
                stringAccumulator = flushLastStringObjectState(stringAccumulator, duplicateStringCount, STRING_DECOR, isDecorated);
            }
            if (objectType.equals("Array")) {
                arrayAccumulator = convertStraightBracketsToCurly(arrayAccumulator);
                arrayAccumulator = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, ARRAY_DECOR, isDecorated);
            }
            if (objectType.equals("Matrix")) {
                arrayAccumulator = convertStraightBracketsToCurly(arrayAccumulator);
                arrayAccumulator = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, MATRIX_DECOR, isDecorated);
            }
            if (objectType.equals("MultiMatrix")) {
                arrayAccumulator = arrayAccumulator.replace("[", "{\n").replace("]", "\n}");
                arrayAccumulator = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, MULTI_MATRIX_DECOR, isDecorated);
            }
            if (objectType.equals("StringVarargs")) {
                arrayAccumulator = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, STRING_DECOR, isDecorated);
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

    private static void accumulateObjectDuplicates(String message, String objectAccumulator, Integer duplicateObjectCount, String lastObject) {
        if (stringAccumulator == null) {
            objectAccumulator = message;
            duplicateObjectCount = 1;
        } else {
            if (message.equals(lastObject)) {
                duplicateObjectCount++;
            } else {
                if (duplicateObjectCount >= 2) {
                    objectAccumulator = objectAccumulator + " (x" + duplicateObjectCount + ")";
                }

                objectAccumulator = objectAccumulator + System.lineSeparator() + message;
                duplicateObjectCount = 1;
            }

        }
        lastObject = message;
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
