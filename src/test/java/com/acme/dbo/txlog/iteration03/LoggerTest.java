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


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutContains(
            "primitives array: {-1, 0, 1}"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {\r\n" +
                "{-1, 0, 1}\r\n" +
                "{1, 2, 3}\r\n" +
                "{-1, -2, -3}\r\n" +
            "}\r\n"
        );
        //endregion
    }
/*
    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Facade.log(new int[][][][] {{{{0}}}});
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
        Facade.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1\nstring 2\nstr 3");
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
        //endregion

        //region then
        assertSysoutContains(1);
        assertSysoutContains("str");
        assertSysoutContains(Integer.MAX_VALUE - 10);
        assertSysoutContains(11);
        //endregion
    }

    */
}