package com.acme.dbo.txlog.iteration03;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.LogWriter;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.message.processor.MessageProcessor;
import com.acme.dbo.txlog.message.processor.RoutingMessageProcessor;
import com.acme.dbo.txlog.message.processor.aggregation.*;
import com.acme.dbo.txlog.message.processor.prefix.PrefixMessageProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
        Facade.init(createAggregationProcessor(), new LogWriter(System.out));
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutEquals( "primitives array: {-1, 0, 1}" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" +System.lineSeparator()+
                "{-1, 0, 1}" + System.lineSeparator()+
                "{1, 2, 3}" + System.lineSeparator() +
                "{-1, -2, -3}" + System.lineSeparator() +
            "}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Facade.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
        "primitives multimatrix: {" + System.lineSeparator() +
                    "{" + System.lineSeparator() +
                        "{" + System.lineSeparator() +
                            "{" + System.lineSeparator() +
                                "0" + System.lineSeparator() +
                            "}"+ System.lineSeparator()  +
                        "}" + System.lineSeparator() +
                    "}" + System.lineSeparator() +
                "}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1" +System.lineSeparator() + "string 2" +System.lineSeparator()+"str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Facade.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Facade.log(1);
        Facade.log("str");
        Facade.log(Integer.MAX_VALUE - 10);
        Facade.log(11);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
    "1" + System.lineSeparator() +
            "str" + System.lineSeparator() +
            (Integer.MAX_VALUE - 10) + System.lineSeparator() +
            "11" + System.lineSeparator()
        );
//        //endregion
    }

    private static MessageProcessor createAggregationProcessor(){

        final String PRIMITIVE = "primitive";

        Map<Class, String> prefixToClassMap = new HashMap<>() {{
            put(ByteMessage.class, PRIMITIVE);
            put(BoolMessage.class, PRIMITIVE);
            put(CharMessage.class, "char");
            put(ObjectMessage.class, "reference");
            put(IntArrayMessage.class, "primitives array");
            put(MatrixMessage.class, "primitives matrix");
            put(MultiMatrixMessage.class, "primitives multimatrix");
        }};

        final MessageProcessor prefixProd =  new PrefixMessageProcessor(prefixToClassMap);

        Map<Class, Function<MessageBase, AggregationBase>> classToCreatorMap = new HashMap<>() {{
            put(IntMessage.class, m->new IntAggregation((IntMessage) m));
            put(StringMessage.class, m->new StringAggregation((StringMessage)m));
        }};
        MessageProcessor aggregatingProc = new AggregatingMessageProcessor(classToCreatorMap);

        Map<Class,MessageProcessor> classToProcessorMap = new HashMap<>();
        classToProcessorMap.putAll(prefixToClassMap.entrySet().stream().collect(Collectors.toMap(x->x.getKey(),x->prefixProd)));
        classToProcessorMap.putAll(classToCreatorMap.entrySet().stream().collect(Collectors.toMap(x->x.getKey(),x->aggregatingProc)));
        return new RoutingMessageProcessor(classToProcessorMap);
    }
}