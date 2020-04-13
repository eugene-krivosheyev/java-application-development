package com.acme.dbo.txlog;

import java.util.Arrays;

class Controller {
    static IntCommand intCommand;
    static StringCommand stringCommand;
    static ByteCommand byteCommand;

    private static Object lastCommand;

    private static String lastCommandType;
    private static String lastArray;

    private static Boolean booleanAccumulator;
    private static String arrayAccumulator;
    private static String matrixAccumulator;
    private static String multiMatrixAccumulator;
    private static String stringVarArgsAccumulator;
    private static String integerVarArgsAccumulator;
    private static Integer duplicateStringCount = 0;
    private static Integer duplicateArrayCount;
    private static Integer duplicateMatrixCount;
    private static Integer duplicateMultiMatrixCount;
    private static Integer duplicateStringVarArgsCount;
    private static Integer duplicateIntegerVarArgsCount;

    private static String PRIMITIVE_DECOR = "primitive: ";
    private static String BOOLEAN_DECOR = PRIMITIVE_DECOR;
    private static String STRING_DECOR = "string: ";
    private static String ARRAY_DECOR = "primitives array: ";
    private static String MATRIX_DECOR = "primitives matrix: ";
    private static String MULTI_MATRIX_DECOR = "primitives multimatrix: ";


    static void log(IntCommand command) {
        if (lastCommand != null) {
            if (lastCommand.getClass().equals(command.getClass())) {
                command.accumulate();
            } else {
                flush();
            }
        }
        lastCommand = command;
    }

    static void log(ByteCommand command) {
        if (lastCommand != null) {
            if (lastCommand.getClass().equals(command.getClass())) {
                command.accumulate();
            } else {
                flush();
            }
        }
        lastCommand = command;
    }

    static void log(StringCommand command) {
        if (lastCommand != null) {
            if (lastCommand.getClass().equals(command.getClass())) {
                StringCommand lastStringCommand = (StringCommand) lastCommand;
                if (lastStringCommand.currentValue.equals(command.currentValue)) {
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

    static void flush() {
        if (lastCommand != null) {
            if ((intCommand != null) && lastCommand.getClass().equals(intCommand.getClass())) {
                WriterFactory.write(IntCommand.getDecoratedState());
                IntCommand.flush();
            }
            if ((stringCommand != null) && lastCommand.getClass().equals(stringCommand.getClass())) {
                if (duplicateStringCount >= 2) {
                    WriterFactory.write(StringCommand.getDecoratedState() + " (x" + duplicateStringCount + ")");
                } else {
                    WriterFactory.write(StringCommand.getDecoratedState());
                }
                StringCommand.flush();
                duplicateStringCount = 0;
            }
            if ((byteCommand != null) && lastCommand.getClass().equals(byteCommand.getClass())) {
                WriterFactory.write(ByteCommand.getDecoratedState());
                ByteCommand.flush();
            }
        }
        flushLastState("Array", "Matrix", "MultiMatrix", "StringVarargs","IntegerVarargs");
        lastCommand = null;
        lastCommandType = null;
    }

    static void logBoolean(boolean message) {

        String msg = String.valueOf(message);
        writeFormattedLog(PRIMITIVE_DECOR, msg);
        lastCommandType = "Boolean";
    }

    static void logChar(char message) {
        String msg = String.valueOf(message);
        String CHAR_DECOR = "char: ";
        writeFormattedLog(CHAR_DECOR, msg);
        lastCommandType = "Char";
    }

    static void log(Object message) {
        String REFERENCE_DECOR = "reference: ";
        System.out.println(REFERENCE_DECOR + message);
        lastCommandType = "Object";
    }

    static void log(int[] ints) {
        if ((lastCommandType != null) && (!lastCommandType.equals("Array"))) {
            flushLastState("Array");
        }
        String currentInts = Arrays.toString(ints);
        PairValues accumulatedPair = accumulateArray(arrayAccumulator, duplicateArrayCount, lastArray, currentInts, ARRAY_DECOR);
        arrayAccumulator = accumulatedPair.getString();
        duplicateArrayCount = accumulatedPair.getInteger();
        lastArray = currentInts;
        lastCommandType = "Array";
    }

    static void log(int[][] ints) {
        if ((lastCommandType != null) && (!lastCommandType.equals("Matrix"))) {
            flushLastState("Matrix");
        }
        String currentInts = Arrays.deepToString(ints);
        PairValues accumulatedPair = accumulateArray(matrixAccumulator, duplicateMatrixCount, lastArray, currentInts, MATRIX_DECOR);
        matrixAccumulator = accumulatedPair.getString();
        duplicateMatrixCount = accumulatedPair.getInteger();
        lastArray = currentInts;
        lastCommandType = "Matrix";
    }

    static void log(int[][][][] ints) {
        if ((lastCommandType != null) && (!lastCommandType.equals("MultiMatrix"))) {
            flushLastState("MultiMatrix");
        }
        String currentInts = Arrays.deepToString(ints);
        PairValues accumulatedPair = accumulateArray(multiMatrixAccumulator, duplicateMultiMatrixCount, lastArray, currentInts, MULTI_MATRIX_DECOR);
        multiMatrixAccumulator = accumulatedPair.getString();
        duplicateMultiMatrixCount = accumulatedPair.getInteger();
        lastArray = currentInts;
        lastCommandType = "MultiMatrix";
    }

    static void log(String... strings) {
        if ((lastCommandType != null) && (!lastCommandType.equals("StringVarargs"))) {
            flushLastState("StringVarargs");
        }
        lastArray = "";
        for (String current : strings) {
            PairValues accumulatedPair = accumulateArray(stringVarArgsAccumulator, duplicateStringVarArgsCount, lastArray, current, "");
            stringVarArgsAccumulator = accumulatedPair.getString();
            duplicateStringVarArgsCount = accumulatedPair.getInteger();
            lastArray = lastArray + current;
        }
        stringVarArgsAccumulator = STRING_DECOR + stringVarArgsAccumulator;
        lastCommandType = "StringVarargs";
    }

    static void log(Integer... integers) {
        if ((lastCommandType != null) && (!lastCommandType.equals("IntegerVarargs"))) {
            flushLastState("IntegerVarargs");
        }
        Integer sumIntegerVarArgs = 0;
        lastArray="";
        for (Integer current : integers) {
            sumIntegerVarArgs = sumIntegerVarArgs + current;
            lastArray = lastArray + current.toString();
        }
        PairValues accumulatedPair = accumulateArray(integerVarArgsAccumulator, duplicateIntegerVarArgsCount, lastArray, sumIntegerVarArgs.toString(), "");
        integerVarArgsAccumulator = accumulatedPair.getString();
        duplicateIntegerVarArgsCount = accumulatedPair.getInteger();
        integerVarArgsAccumulator = PRIMITIVE_DECOR + integerVarArgsAccumulator;
        lastCommandType = "IntegerVarargs";
    }

    private static void writeFormattedLog(String decoration, Object message) {
        writeOutput(decoration + message);
    }

    private static void writeOutput(Object msg) {
        System.out.println(msg);
    }

    private static void flushLastState(String... types) {
        for (String current : types) {
            if (current.equals("Boolean")) {
                flushLastBooleanState();
            }
            if (current.equals("Array")) {
                PairValues flushedPair = flushLastStringObjectState(arrayAccumulator, duplicateArrayCount, ARRAY_DECOR);
                arrayAccumulator = flushedPair.getString();
                duplicateArrayCount = flushedPair.getInteger();
            }
            if ((current.equals("Matrix") && (matrixAccumulator != null))) {
                matrixAccumulator = matrixAccumulator.replace("], ", "]");
                PairValues flushedPair = flushLastStringObjectState(matrixAccumulator, duplicateMatrixCount, MATRIX_DECOR);
                matrixAccumulator = flushedPair.getString();
                duplicateMatrixCount = flushedPair.getInteger();
            }
            if ((current.equals("MultiMatrix") && (multiMatrixAccumulator != null))) {
                multiMatrixAccumulator = multiMatrixAccumulator.replace("], ", "]");
                PairValues flushedPair = flushLastStringObjectState(multiMatrixAccumulator, duplicateMultiMatrixCount, MULTI_MATRIX_DECOR);
                multiMatrixAccumulator = flushedPair.getString();
                duplicateMultiMatrixCount = flushedPair.getInteger();
            }
            if ((current.equals("StringVarargs") && (stringVarArgsAccumulator != null))) {
                stringVarArgsAccumulator = stringVarArgsAccumulator.replace("], ", "]");
                PairValues flushedPair = flushLastStringObjectState(stringVarArgsAccumulator, duplicateStringVarArgsCount, STRING_DECOR);
                stringVarArgsAccumulator = flushedPair.getString();
                duplicateStringVarArgsCount = flushedPair.getInteger();
            }
            if ((current.equals("IntegerVarargs") && (integerVarArgsAccumulator != null))) {
//                integerVarArgsAccumulator = integerVarArgsAccumulator.replace("], ", "]");
                PairValues flushedPair = flushLastStringObjectState(integerVarArgsAccumulator, duplicateIntegerVarArgsCount, PRIMITIVE_DECOR);
                integerVarArgsAccumulator = flushedPair.getString();
                duplicateIntegerVarArgsCount = flushedPair.getInteger();
            }
        }
    }

    private static void flushLastBooleanState() {
        if (booleanAccumulator != null) {
            writeFormattedLog(BOOLEAN_DECOR, booleanAccumulator);
        }
        booleanAccumulator = null;
    }

    private static PairValues flushLastStringObjectState(String arrayType, Integer duplicateCount, String decoration) {
        if (arrayType != null) {
            if (duplicateCount >= 1) {
                arrayType = arrayType + " (x" + duplicateCount + ")";
            }
            writeFormattedLog(decoration, arrayType);
        }
        return new PairValues(null, null);
    }

    private static PairValues accumulateArray(String arrayAccumulator, Integer duplicateObjectCount, String lastArrayString, String stringArray, String decoration) {

        if (arrayAccumulator == null) {
            arrayAccumulator = stringArray;
            duplicateObjectCount = 0;
        } else {
            if (lastArrayString.equals(stringArray)) {
                duplicateObjectCount++;
            } else {
                arrayAccumulator = arrayAccumulator + System.lineSeparator() + decoration + stringArray;
            }
        }
        return new PairValues(arrayAccumulator, duplicateObjectCount);
    }
}