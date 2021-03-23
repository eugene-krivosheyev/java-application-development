package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

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
        String str1 = "str 1";
        String str2 = "str 2";
        int int1 = 1;
        int int2 = 2;
        int int3 = 0;
        //region when
        Facade.log(str1);
        Facade.log(int1);
        Facade.log(int2);
        Facade.log(str2);
        Facade.log(int3);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(str1 + lineSeparator());
        assertSysoutContains(int1 + int2 + "" + lineSeparator());
        assertSysoutContains(str2 + lineSeparator());
        assertSysoutContains(int3 + "" + lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        String str1 = "str 1";
        String str2 = "str 2";
        int int1 = 10;
        int int2 = Integer.MAX_VALUE;
        int int3 = 0;
        //region when
        Facade.log(str1);
        Facade.log(int1);
        Facade.log(int2);
        Facade.log(str2);
        Facade.log(int3);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(str1 + lineSeparator());
        assertSysoutContains(int1 + lineSeparator());
        assertSysoutContains(int2 + lineSeparator());
        assertSysoutContains(str2 + lineSeparator());
        assertSysoutContains(int3 + lineSeparator());

        //endregion
    }
    /*
    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1");
        Facade.log((byte)10);
        Facade.log((byte)Byte.MAX_VALUE);
        Facade.log("str 2");
        Facade.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Byte.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
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
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        //endregion
    }

    */
}