package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.LogWriter;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.message.processor.aggregation.AggregatingMessageProcessor;
import com.acme.dbo.txlog.message.processor.MessageProcessor;
import com.acme.dbo.txlog.message.processor.aggregation.AggregationBase;
import com.acme.dbo.txlog.message.processor.aggregation.IntAggregation;
import com.acme.dbo.txlog.message.processor.aggregation.StringAggregation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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
    //endregion

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Facade.log("str 1");
        Facade.log(1);
        Facade.log(2);
        Facade.log("str 2");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "3" + System.lineSeparator() +
            "str 2" + System.lineSeparator()+
            "0" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Facade.log("str 1");
        Facade.log(10);
        Facade.log(Integer.MAX_VALUE);
        Facade.log("str 2");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "10" + System.lineSeparator() +
            Integer.MAX_VALUE + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "0" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1");
        Facade.log((byte)10);
        Facade.log((byte)Byte.MAX_VALUE);
        Facade.log("str 2");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "10" + System.lineSeparator() +
            Byte.MAX_VALUE  + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "0" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Facade.log("str 1");
        Facade.log("str 2");
        Facade.log("str 2");
        Facade.log(0);
        Facade.log("str 2");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "str 2 (x2)" + System.lineSeparator() +
            "0" + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "str 3 (x3)" + System.lineSeparator()
        );
        //endregion
    }

    private static MessageProcessor createAggregationProcessor(){
        Map<Class, Function<MessageBase, AggregationBase>> classToCreatorMap = new HashMap<>() {{
            put(IntMessage.class, m->new IntAggregation((IntMessage) m));
            put(StringMessage.class, m->new StringAggregation((StringMessage)m));

        }};

        return new AggregatingMessageProcessor(classToCreatorMap);
    }


}