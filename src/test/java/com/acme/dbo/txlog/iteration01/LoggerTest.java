package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private final String prefix = "primitive: ";
    private final String lineSeparator = lineSeparator();
    private String logResultInt(int number){
        return prefix + number + lineSeparator;
    }
    private String logResultByte(byte number){
        return prefix + number + lineSeparator;
    }

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
    public void shouldLogInteger() throws IOException {
        int number1 = 1;
        int number2 = 0;
        int number3 = -1;

        //region when
        Facade.log(number1);
        Facade.log(number2);
        Facade.log(number3);
        //endregion

        //region then
        assertSysoutContains(prefix);
        assertSysoutEquals(logResultInt(number1) +
                                    logResultInt(number2) +
                                    logResultInt(number3));
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        byte number1 = 1;
        byte number2 = 0;
        byte number3 = -1;


        //region when
        Facade.log(number1);
        Facade.log(number2);
        Facade.log(number3);
        //endregion

        //region then
        assertSysoutContains(prefix);
        assertSysoutContains(Integer.toString(number1));
        assertSysoutContains(Integer.toString(number2));
        assertSysoutContains(Integer.toString(number3));
        //endregion
    }

    /*
    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Facade.log('a');
        Facade.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Facade.log("test string 1");
        Facade.log("other str");
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Facade.log(true);
        Facade.log(false);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Facade.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

    */
}