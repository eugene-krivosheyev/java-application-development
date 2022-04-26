package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
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
        assertSysoutContains(String.format("str 1%n"));
        assertSysoutContains(String.format("3%n"));
        assertSysoutContains(String.format("str 2%n"));
        assertSysoutContains(String.format("0%n"));
        //endregion
    }


    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Facade.log("str 1");
        Facade.log(10);
        Facade.log(Integer.MAX_VALUE);
        Facade.log("str 2");
        Facade.log(-10);
        Facade.log(Integer.MIN_VALUE);
        Facade.log(0);
        Facade.log("str 3");
        Facade.log(-5);
        Facade.log(10);
        Facade.log("str 4");
        Facade.log(20);
        Facade.log(-101);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(String.format("str 1%n"));
        assertSysoutContains(String.format("10%n"));
        assertSysoutContains(String.format(Integer.MAX_VALUE + "%n"));
        assertSysoutContains(String.format("str 2%n"));
        assertSysoutContains(String.format("0%n"));
        assertSysoutContains(String.format("-10%n"));
        assertSysoutContains(String.format(Integer.MIN_VALUE + "%n"));
        assertSysoutContains(String.format("str 3%n"));
        assertSysoutContains(String.format("5%n"));
        assertSysoutContains(String.format("str 4%n"));
        assertSysoutContains(String.format("-81%n"));
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1");
        Facade.log((byte)10);
        Facade.log((byte)Byte.MAX_VALUE);
        Facade.log("str 2");
        Facade.log((byte)-10);
        Facade.log((byte)Byte.MIN_VALUE);
        Facade.log("str 3");
        Facade.log((byte)-55);
        Facade.log((byte)100);
        Facade.log("str 4");
        Facade.log((byte)17);
        Facade.log((byte)-35);
        Facade.log("str 5");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(String.format("str 1%n"));
        assertSysoutContains(String.format("10%n"));
        assertSysoutContains(String.format(Byte.MAX_VALUE + "%n"));
        assertSysoutContains(String.format("str 2%n"));
        assertSysoutContains(String.format("-10%n"));
        assertSysoutContains(String.format(Byte.MIN_VALUE + "%n"));
        assertSysoutContains(String.format("str 3%n"));
        assertSysoutContains(String.format("45%n"));
        assertSysoutContains(String.format("str 4%n"));
        assertSysoutContains(String.format("-18%n"));
        assertSysoutContains(String.format("str 5%n"));
        assertSysoutContains(String.format("0%n"));
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
        assertSysoutContains(String.format("str 1%n"));
        assertSysoutContains(String.format("str 2 (x2)"));
        assertSysoutContains(String.format("0%n"));
        assertSysoutContains(String.format("str 2%n"));
        assertSysoutContains(String.format("str 3 (x3)%n"));
        //endregion
    }

}