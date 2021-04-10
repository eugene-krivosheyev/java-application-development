package com.acme.dbo.txlog;

import org.junit.Test;

public class TmpTest {

    @Test
    public void shouldLogInteger() {
        //region when
        Facade.log(1);
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        Facade.log(-1);
        Facade.flush();
        //endregion
    }
}