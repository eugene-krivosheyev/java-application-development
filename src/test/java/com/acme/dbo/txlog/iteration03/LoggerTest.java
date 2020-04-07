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
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Facade.stop();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives matrix: {" + System.lineSeparator() +
                        "{-1, 0, 1}" + System.lineSeparator() +
                        "{1, 2, 3}" + System.lineSeparator() +
                        "{-1, -2, -3}" + System.lineSeparator() +
                        "}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Facade.log(new int[][][][]{{{{0}}}});
        Facade.stop();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives multimatrix: {" + System.lineSeparator() +
                        "{" + System.lineSeparator() + "{" + System.lineSeparator() +
                        "{0}" + System.lineSeparator() +
                        "}" + System.lineSeparator() + "}" + System.lineSeparator() +
                        "}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log("str1", "string 2", "str 3");
        Facade.stop();
        //endregion

        //region then
        assertSysoutContains("str1" + System.lineSeparator());
        assertSysoutContains("string 2" + System.lineSeparator());
        assertSysoutContains("str 3" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Facade.log(-1, 0, 1, 3);
        Facade.stop();
        //endregion

        //region then
        assertSysoutEquals("primitive: 3" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Facade.log(1);
        Facade.log("str");
        Facade.log(Integer.MAX_VALUE - 10);
        Facade.log(11);
        Facade.stop();
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("str");
        assertSysoutContains(Integer.toString(Integer.MAX_VALUE - 10));
        assertSysoutContains("11");
        //endregion
    }
}