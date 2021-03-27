package com.acme.dbo.txlog;

public class Facade {

    private static int stopSymbol = 0;
    private static int globalAggregationStringCounter = 1;
    private static int finalAggregationStringCounter = 1;
    private static String aggregatedType = "";
    private static String aggregatedValueCurrent = "";
    private static String aggregatedValueToPrint = "";
    private static String aggregatedValueFinal = ""; //to return in 0 case and cleanup aggregatedValueCurrent and aggregatedValueToPrint
    private static boolean shallIprint = false;

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string prefix: ";
    private static final String OBJECT_PREFIX = "reference: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String OBJECT_POSTFIX = "";


    public static void log(int message) {
        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(byte message) {
        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(String message) {
        print(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }

    public static void log(Boolean message) {
        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        print(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    private static void print(String message) {
        if (shallIprint) {
            System.out.println(message);
        }
    }

    private static String decorate(String prefix, Object message, String postfix) {
        message = tryToAggregate(message);
        //      return prefix + message + postfix;
        return message.toString();
    }

    private static Object aggregate(Object previouslyAggreagated, Object addition) {
        Object aggregationResult;
        if (addition instanceof String) {
            if (previouslyAggreagated.toString().contains(addition.toString())){
                globalAggregationStringCounter++;
           //     System.out.println("Counter increased");
            }
            aggregationResult = addition.toString();
        } else if (addition instanceof Integer) {
            aggregationResult = Integer.valueOf(previouslyAggreagated.toString()) + Integer.valueOf(addition.toString());
        } else if (addition instanceof Byte) {
            aggregationResult = Byte.valueOf(previouslyAggreagated.toString()) + Byte.valueOf(addition.toString());
        } else return "ERROR: Type is not String,Integer or Byte";
        return aggregationResult;
    }

    private static boolean checkIFMax(Object message) {
        if (message instanceof Integer) {
            if (Integer.MAX_VALUE == Integer.valueOf(message.toString())) {
                return true;
            }
        }
        if (message instanceof Byte) {
            if (Byte.MAX_VALUE == Byte.valueOf(message.toString())) {
                return true;
            }
        }
        return false;
    }

    private static Object addMultiplicatorIfRequired (Object message, int multiplicator){
        if (multiplicator == 1){
            return message;
        }
        else{
            return message.toString() + " (x"+multiplicator+")";
        }
    }



    //Returns same Object, but with side effect - changes pritYNFlag if type has changed
    private static Object tryToAggregate(Object message) {
        if (shallIprint) {
            aggregatedValueToPrint = aggregatedValueCurrent;
        }
        if (message.toString().equals(String.valueOf(stopSymbol))) {
            shallIprint = true;
            aggregatedType = "";
            finalAggregationStringCounter = globalAggregationStringCounter;
            globalAggregationStringCounter = 1;
            aggregatedValueFinal = addMultiplicatorIfRequired(aggregatedValueToPrint,finalAggregationStringCounter) + System.getProperty("line.separator") + "0";
        //    System.out.println("Zero case " + "curr =" + aggregatedValueCurrent + " ." + "toprint =" + aggregatedValueToPrint + " ." + aggregatedType);
            aggregatedValueToPrint = aggregatedValueCurrent = new String("");
            return aggregatedValueFinal;
        } else if (aggregatedType.equals("")) {
            aggregatedType = message.getClass().toString();
            aggregatedValueCurrent = aggregatedValueToPrint = message.toString();
            shallIprint = false;
        //   System.out.println("First Input case " + "curr =" + aggregatedValueCurrent + " ." + "toprint =" + aggregatedValueToPrint + " ." + aggregatedType);
        } else {
            if (!(message instanceof String) && aggregatedType.equals(message.getClass().toString()) && !checkIFMax(message)) {
                shallIprint = false;
                aggregatedValueToPrint = aggregate(aggregatedValueToPrint, message).toString();
        //        System.out.println("Aggregation int case " + "curr =" + aggregatedValueCurrent + " ." + "toprint =" + aggregatedValueToPrint + " ." + aggregatedType);
            }
            else if ((message instanceof String) && aggregatedType.equals(message.getClass().toString()) && aggregatedValueToPrint.equals(message)){
                shallIprint = false;
                aggregatedValueToPrint = aggregate(aggregatedValueToPrint, message).toString(); //ony increases counter
        //        System.out.println("Aggregation str case " + "curr =" + aggregatedValueCurrent + " ." + "toprint =" + aggregatedValueToPrint + " ." + globalAggregationStringCounter);
            }
            else if (message instanceof String){
                shallIprint = true;
                aggregatedType = message.getClass().toString();
                aggregatedValueCurrent = message.toString();
        //        System.out.println("Stop str aggregation case: " + "curr =" + aggregatedValueCurrent + " ." + "toprint =" + aggregatedValueToPrint + " ." + globalAggregationStringCounter);
                finalAggregationStringCounter = globalAggregationStringCounter;
                globalAggregationStringCounter = 1;
            }
            else {
                shallIprint = true;
                aggregatedType = message.getClass().toString();
                aggregatedValueCurrent = message.toString();
                finalAggregationStringCounter = globalAggregationStringCounter;
                globalAggregationStringCounter = 1;
       //         System.out.println("Stop int aggregation case: " + "curr =" + aggregatedValueCurrent + " ." + "toprint =" + aggregatedValueToPrint + " ." + aggregatedType);
            }
        }
        return addMultiplicatorIfRequired(aggregatedValueToPrint,finalAggregationStringCounter);
    }



}
