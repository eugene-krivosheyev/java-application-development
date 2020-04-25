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
//        Facade.flush();
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1\n" +
                        "primitive: 3\n" +
                        "string: str 2\n" +
                        "primitive: 0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws IOException {
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
                "string: str 1\n" +
                        "primitive: 10\n" +
                        "primitive: "+Integer.MAX_VALUE + "\n" +
                        "string: str 2\n" +
                        "primitive: 0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws IOException {
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
            "string: str 1\n" +
            "primitive: 10\n" +
            "primitive: "+Byte.MAX_VALUE + "\n" +
            "string: str 2\n" +
            "primitive: 0\n"
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
            "string: str 1\n" +
            "string: str 2 (x2)\n" +
            "primitive: 0\n" +
            "string: str 2\n" +
            "string: str 3 (x3)\n"
        );
        //endregion
    }

}