package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.acme.dbo.txlog.Facade.clear;

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



    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Facade.log("str 1", false);
        Facade.log(1, false);
        Facade.log(2, false);
        Facade.log("str 2", false);
        Facade.log(0, false);
        Facade.clear();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1"  + System.getProperty("line.separator") +
                    "3"  + System.getProperty("line.separator") +
                    "str 2"  + System.getProperty("line.separator") +
                    "0"  + System.getProperty("line.separator")
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Facade.log("str 1", false);
        Facade.log(10, false);
        Facade.log(Integer.MAX_VALUE, false);
        Facade.log("str 2", false);
        Facade.log(0, false);
        Facade.clear();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1"  + System.getProperty("line.separator") +
                    "10"  + System.getProperty("line.separator") +
                    Integer.MAX_VALUE  + System.getProperty("line.separator") +
                    "str 2"  + System.getProperty("line.separator") +
                    "0"  + System.getProperty("line.separator")
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1", false);
        Facade.log((byte)10, false);
        Facade.log((byte)Byte.MAX_VALUE, false);
        Facade.log("str 2", false);
        Facade.log(0, false);
        Facade.clear();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1"  + System.getProperty("line.separator") +
                    "10"  + System.getProperty("line.separator") +
                    Byte.MAX_VALUE + System.getProperty("line.separator") +
            "str 2"  + System.getProperty("line.separator") +
                    "0"  + System.getProperty("line.separator")
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Facade.log("str 1", false);
        Facade.log("str 2", false);
        Facade.log("str 2", false);
        Facade.log(0, false);
        Facade.log("str 2", false);
        Facade.log("str 3", false);
        Facade.log("str 3", false);
        Facade.log("str 3", false);
        Facade.clear();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1"  + System.getProperty("line.separator") +
                    "str 2 (x2)"  + System.getProperty("line.separator") +
                    "0"  + System.getProperty("line.separator") +
                    "str 2"  + System.getProperty("line.separator") +
                    "str 3 (x3)"  + System.getProperty("line.separator")
        );
        //endregion
    }


}