package com.acme.dbo.txlog.iteration03;

import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.acme.dbo.txlog.Facade;
import static java.lang.System.lineSeparator;

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


//    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}" + lineSeparator()
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
            "primitives matrix: {" + lineSeparator() +
                "{-1, 0, 1}" + lineSeparator() +
                "{1, 2, 3}" + lineSeparator() +
                "{-1, -2, -3}" + lineSeparator() +
            "}" + lineSeparator()
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
            "primitives multimatrix: {" + lineSeparator() +
                "{" + lineSeparator() + "{" + lineSeparator() + "{" + lineSeparator() +
                    "0" + lineSeparator() +
                "}" + lineSeparator() + "}" + lineSeparator() + "}" + lineSeparator() +
            "}" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log("str1", "string 2", "str 3");
        Facade.clear();
        //endregion

        //region then
        assertSysoutContains("string: str1" + lineSeparator() + "string: string 2"  + lineSeparator() + "string: str 3");
        //endregion
    }
/*
    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Facade.log(-1, 0, 1, 3);
//        Facade.clear();
        //endregion

        //region then
        assertSysoutContains("primitive: 3");
        //endregion
    }
*/
    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Facade.log(1);
        Facade.log("str");
        Facade.log(Integer.MAX_VALUE - 10);
        Facade.log(11);
        Facade.clear();
        //endregion

        //region then
        assertSysoutContains( "1");
        assertSysoutContains("str");
        assertSysoutContains(Integer.toString(Integer.MAX_VALUE - 10));
        assertSysoutContains("11");
        //endregion
    }


}