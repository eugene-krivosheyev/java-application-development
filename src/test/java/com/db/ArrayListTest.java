package com.db;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListTest {
    @Test
    public void shouldSizeIncrementedWhenElementAdded() {
        //region Fixture | Given
        ArrayList sut = new ArrayList();
        Object dummy = new Object();
        assumeTrue(sut.isEmpty());
        //endregion

        //region When
        sut.add(dummy);
        //endregion

        //region Then
        assertEquals(1, sut.size());
        //endregion
    }

    @Test
    public void shouldRelyOnElementsStateWhenToString() {
        //region Given
        ArrayList sut = new ArrayList();
        Object stub = mock(Object.class);
        when(stub.toString()).thenReturn("test string");
        sut.add(stub);
        //endregion

        //region When
        String result = sut.toString();
        //endregion

        //region Then
        assertTrue(result.contains("test string"));
    }
}
