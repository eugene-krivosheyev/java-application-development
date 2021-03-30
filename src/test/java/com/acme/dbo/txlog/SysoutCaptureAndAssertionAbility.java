package com.acme.dbo.txlog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public interface SysoutCaptureAndAssertionAbility {
    ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    default void captureSysout() {
        System.setOut(new PrintStream(OUT));
    }

    default void assertSysoutEquals(String expected) {
        assertThat(OUT.toString()).isEqualTo(expected);
    }

    default void assertSysoutContains(String expected) {
        assertThat(OUT.toString()).contains(expected);
    }

    default void assertSysoutContains(int expected) {
        assertThat(OUT.toString()).contains(String.valueOf(expected));
    }

    default void resetOut() {
        OUT.reset();
    }
}
