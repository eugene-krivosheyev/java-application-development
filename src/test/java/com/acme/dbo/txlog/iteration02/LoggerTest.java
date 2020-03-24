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
        Facade.log("str 1",false);
        Facade.log(1,false);
        Facade.log(2,false);
        Facade.log("str 2",false);
        Facade.flush(false);
        Facade.log(0,false);
        Facade.flush(false);
        //endregion

        //region then
        assertSysoutEquals(
                "str 1\n" +
                        "3\n" +
                        "str 2\n" +
                        "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Facade.log("str 1",false);
        Facade.log(10,false);
        Facade.log(Integer.MAX_VALUE,false);
        Facade.log("str 2",false);
        Facade.log(0,false);
        Facade.flush(false);
        //endregion

        //region then
        assertSysoutEquals(
                "str 1\n" +
                        "10\n" +
                        Integer.MAX_VALUE + "\n" +
                        "str 2\n" +
                        "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1",false);
        Facade.log((byte)10,false);
        Facade.log((byte)Byte.MAX_VALUE,false);
        Facade.log("str 2",false);
        Facade.log(0,false);
        Facade.flush(false);
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

//    @Test
//    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
//        //region when
//        Facade.log("str 1");
//        Facade.log("str 2");
//        Facade.log("str 2");
//        Facade.log(0);
//        Facade.log("str 2");
//        Facade.log("str 3");
//        Facade.log("str 3");
//        Facade.log("str 3");
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "str 1\n" +
//            "str 2 (x2)\n" +
//            "0\n" +
//            "str 2\n" +
//            "str 3 (x3)\n"
//        );
//        //endregion
//    }

}