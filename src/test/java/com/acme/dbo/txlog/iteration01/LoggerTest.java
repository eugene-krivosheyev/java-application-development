package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    public static final char CHAR_FROMAT_PREFIX = 'a';
    public static final char FREFIX_ = 'b';

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
        //region when
        Facade.log(1);
        Facade.flush();

        Facade.log(0);
        Facade.flush();

        Facade.log(-1);
        Facade.flush();

        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 0");
        assertSysoutContains("primitive: -1");

//        assertSysoutEquals("primitive: 1" + lineSeparator() + "primitive: 0\r\nprimitive: -1\r\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Facade.log((byte)1);
        Facade.log((byte)0);
        Facade.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");

        assertSysoutEquals("dsgfdg" + lineSeparator() + "fkgdkgjdhg");
//        ps("fgjdkgjhdkf \ndfkghdkjghdfkjgh")
//        Apache Jakarta Commons Lang | Collections | IO
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Facade.log(CHAR_FROMAT_PREFIX);
        Facade.log(FREFIX_);
        //endregion
//        printA( formatB(pr,mess) )

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("a");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
//        Facade.log("test string 1");
//        Facade.log("other str");
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
//        Facade.log(true);
//        Facade.log(false);
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
//        Facade.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}