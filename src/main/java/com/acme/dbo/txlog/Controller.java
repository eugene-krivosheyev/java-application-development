package com.acme.dbo.txlog;

import java.util.Arrays;

public class Controller {
    public static IntCommand intCommand;
    public static StringCommand stringCommand;
    public static ByteCommand byteCommand;
    private static Object lastCommand;
    private static Byte byteAccumulator;
    private static Boolean booleanAccumulator;
    private static String charAccumulator;
    private static String stringAccumulator;
    private static String lastString;
    private static String lastCommandType;
    private static Integer duplicateStringCount = 0;
    private static String arrayAccumulator;
    private static String matrixAccumulator;
    private static String multiMatrixAccumulator;
    private static String varArgsAccumulator;
    private static Integer duplicateArrayCount;
    private static Integer duplicateCharCount;
    private static Integer duplicateMatrixCount;
    private static Integer duplicateMultiMatrixCount;
    private static Integer duplicateVarArgsCount;
    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String BOOLEAN_DECOR = PRIMITIVE_DECOR;
    private static String STRING_DECOR = "string: ";
    private static String CHAR_DECOR = "char: ";
    private static String REFERENCE_DECOR = "reference: ";
    private static String ARRAY_DECOR = "primitives array: ";
    private static String MATRIX_DECOR = "primitives matrix: ";
    private static String MULTI_MATRIX_DECOR = "primitives multimatrix: ";


    public static void log(IntCommand command) {
        if (lastCommand != null) {
            if (lastCommand.getClass().equals(command.getClass())) {
                command.accumulate();
            } else {
                flush();
            }
        }
        lastCommand = command;
    }

    public static void log(ByteCommand command) {
        if (lastCommand != null) {
            if (lastCommand.getClass().equals(command.getClass())) {
                command.accumulate();
            } else {
                flush();
            }
        }
        lastCommand = command;
    }

    public static void log(StringCommand command) {
        if (lastCommand != null) {
            if (lastCommand.getClass().equals(command.getClass())) {
                StringCommand lastStringCommand = (StringCommand) lastCommand;
                if (lastStringCommand.currentValue == command.currentValue) {
                    duplicateStringCount++;
                } else {
                    command.accumulate();
                    duplicateStringCount = 1;
                }
            } else {
                flush();
            }
        }
        lastCommand = command;
    }

    public static void flush() {
        if (lastCommand != null) {
            if ((intCommand != null) && lastCommand.getClass().equals(intCommand.getClass())) {
                WriterFactory.write(intCommand.getDecoratedState());
                IntCommand.flush();
            }
            if ((stringCommand != null) && lastCommand.getClass().equals(stringCommand.getClass())) {
                if (duplicateStringCount >= 2) {
                    WriterFactory.write(stringCommand.getDecoratedState() + " (x" + duplicateStringCount + ")");
                } else {
                    WriterFactory.write(stringCommand.getDecoratedState());
                }
                stringCommand.flush();
                duplicateStringCount = 0;
            }
            if ((byteCommand != null) && lastCommand.getClass().equals(byteCommand.getClass())) {
                WriterFactory.write(byteCommand.getDecoratedState());
                byteCommand.flush();
            }
        }
        flushLastState("Array", "Matrix", "MultiMatrix", "StringVarargs");
        lastCommand = null;
        lastCommandType = null;
    }

    public static void logBoolean(boolean message) {

        String msg = String.valueOf(message);
        writeFormattedLog(PRIMITIVE_DECOR, msg);
        lastCommandType = "Boolean";
    }

    public static void logChar(char message) {

        String msg = String.valueOf(message);
        writeFormattedLog(CHAR_DECOR, msg);
        lastCommandType = "Char";
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_DECOR + message);
        lastCommandType = "Object";
    }

    public static void log(int[] ints) {
        PairValues accumulatedPair = accumulateArray(arrayAccumulator, duplicateArrayCount, Arrays.toString(ints));
        arrayAccumulator = accumulatedPair.getString();
        duplicateArrayCount = accumulatedPair.getInteger();
        lastCommandType = "Array";
    }

    public static void log(int[][] ints) {
        PairValues accumulatedPair = accumulateArray(matrixAccumulator, duplicateMatrixCount, Arrays.deepToString(ints));
        matrixAccumulator = accumulatedPair.getString();
        duplicateMatrixCount = accumulatedPair.getInteger();
        lastCommandType = "Matrix";
    }

    public static void log(int[][][][] ints) {
        PairValues accumulatedPair = accumulateArray(multiMatrixAccumulator, duplicateMultiMatrixCount, Arrays.deepToString(ints));
        multiMatrixAccumulator = accumulatedPair.getString();
        duplicateMultiMatrixCount = accumulatedPair.getInteger();
        lastCommandType = "MultiMatrix";
    }

    public static void log(String... strings) {
        for (String current : strings) {
            PairValues accumulatedPair = accumulateArray(varArgsAccumulator, duplicateVarArgsCount, current);
            varArgsAccumulator = accumulatedPair.getString();
            duplicateVarArgsCount = accumulatedPair.getInteger();
        }
        lastCommandType = "StringVarargs";
    }

    private static void writeFormattedLog(String decoration, Object message) {
        writeOutput(decoration + message);
    }

    private static void writeOutput(Object msg) {
        System.out.println(msg);
    }

    public static void flushLastState(String... types) {
        for (String current : types) {
            if (current.equals("Boolean")) {
                flushLastBooleanState();
            }
            if (current.equals("Char")) {
                flushLastStringLikeAccumulatorState("Char");
            }
            if (current.equals("Array")) {
                flushLastStringLikeAccumulatorState("Array");
            }
            if (current.equals("Matrix")) {
                flushLastStringLikeAccumulatorState("Matrix");
            }
            if (current.equals("MultiMatrix")) {
                flushLastStringLikeAccumulatorState("MultiMatrix");
            }
            if (current.equals("StringVarargs")) {
                flushLastStringLikeAccumulatorState("StringVarargs");
            }
        }
    }


    private static void flushLastBooleanState() {
        if (booleanAccumulator != null) {
            writeFormattedLog(BOOLEAN_DECOR, booleanAccumulator);
        }
        booleanAccumulator = null;
    }

    private static void flushLastStringLikeAccumulatorState(String objectType) {
        if (objectType != null) {
            if (objectType.equals("Char")) {
                charAccumulator = flushLastStringObjectState(charAccumulator, duplicateCharCount, CHAR_DECOR);
            }
            if (objectType.equals("Array")) {
                if (arrayAccumulator != null) {
                    arrayAccumulator = convertStraightBracketsToCurly(arrayAccumulator);
                }
                arrayAccumulator = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, ARRAY_DECOR);
            }
            if (objectType.equals("Matrix")) {
                if (matrixAccumulator != null) {
                    matrixAccumulator = convertStraightBracketsToCurly(matrixAccumulator);
                }
                matrixAccumulator = flushLastStringObjectState(matrixAccumulator, duplicateMatrixCount, MATRIX_DECOR);
            }
            if (objectType.equals("MultiMatrix")) {
                if (multiMatrixAccumulator != null) {
                    multiMatrixAccumulator = multiMatrixAccumulator.replace("[", "{\n").replace("]", "\n}");
                }
                multiMatrixAccumulator = flushLastStringObjectState(multiMatrixAccumulator, duplicateMultiMatrixCount, MULTI_MATRIX_DECOR);
            }
            if (objectType.equals("StringVarargs")) {
                varArgsAccumulator = flushLastStringObjectState(varArgsAccumulator, duplicateVarArgsCount, STRING_DECOR);
            }
        }
    }

    private static String flushLastStringObjectState(String arrayType, Integer duplicateCount, String decoration) {
        if (arrayType != null) {
            if (duplicateCount >= 2) {
                arrayType = arrayType + " (x" + duplicateCount + ")";
            }
            writeFormattedLog(decoration, arrayType);
        }
        return null;
    }

    public static PairValues accumulateArray(String arrayAccumulator, Integer
            duplicateObjectCount, String stringArray) {

        if (arrayAccumulator == null) {
            arrayAccumulator = stringArray;
            duplicateObjectCount = 1;
        } else {
            arrayAccumulator = arrayAccumulator + System.lineSeparator() + stringArray;
            duplicateObjectCount++;
        }

        return new PairValues(arrayAccumulator, duplicateObjectCount);
    }

    private static String convertStraightBracketsToCurly(String text) {
        text = text.replace("[", "{").replace("]", "}");
        while (text.contains("{{") == true) {
            text = text.replace("{{", "{\n{").replace("}}", "}\n}");
        }
        return text.replace("}, ", "}\n");
    }
}