package com.nokia.unittests;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    private List<String> values;

    @Before
    public void setUp() {
        // given
        values = new ArrayList<String>();
    }

    @Test
    public void shouldAddElement() {
        // when
        values.add("element");

        // then
        Assert.assertThat(values.get(0), IsEqual.equalTo("element"));
    }

    @Test
    public void shouldRemoveElement() {
        // given
        values.add("element");

        // when
        values.remove(0);

        // then
        Assert.assertThat(values.size(), IsEqual.equalTo(0));
    }

    @Test
    public void shouldFindElementUsingIndex() {
        // given
        values.add("element-1");
        values.add("element-2");

        // when
        String elementUnderIndex = values.get(1);

        // then
        Assert.assertThat(elementUnderIndex, IsEqual.equalTo("element-2"));
    }

}
