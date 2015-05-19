package com.db;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assume.*;
import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void shouldSizeIncrementedWhenElementAdded() {
        //Given
        ArrayList arrayList = new ArrayList();
        Object dummy = new Object();

        //When
        arrayList.add(dummy);

        //Then
        assertEquals(2, arrayList.size());
    }
}
