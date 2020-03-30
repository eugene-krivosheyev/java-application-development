package com.acme.dbo.txlog.iteration03;

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
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[] {-1, 0, 1},true);
        Facade.flush(true);
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }


    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}},true);
        Facade.flush(true);
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
            "}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Facade.log(new int[][][][] {{{{0}}}},true);
        Facade.flush(true);
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {\n" +
                "{\n" + "{\n" + "{\n" +
                    "0\n" +
                "}\n" + "}\n" + "}\n" +
            "}\n"
        );
        //endregion
    }


    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log(false, "str1", "string 2", "str 3");
        Facade.flush(false);
        //endregion

        //region then
        assertSysoutContains("str1\nstring 2\nstr 3");
        //endregion
    }
/*
    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Facade.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }
    */
//    @Test
//    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
//        //region when
//        Facade.log(1,false);
//        Facade.log("str",false);
//        Facade.log(Integer.MAX_VALUE - 10,false);
//        Facade.log(11,false);
//        Facade.flush(false);
//        //endregion
//
//        //region then
//        assertSysoutContains("1");
//        assertSysoutContains("str");
//        assertSysoutContains("Integer.MAX_VALUE - 10");
//        assertSysoutContains("11");
//        //endregion
//    }


}