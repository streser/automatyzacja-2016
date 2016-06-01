package com.nokia.unittest;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstJUnitTest {
    
    private static ArrayList<String> list;
    
    @BeforeClass
    public static void newList() {
	list = new ArrayList<String>();
    }
    
    @Before
    public void cleanList() {
	if (list==null)
	    return;
	if (list.size()>0)
	    list.clear();
    }
    
    @Test
    public void insertTest() {
	list.add("1");
	list.add("2");
	list.add("3");
	
	Assert.assertThat(list.size(), IsEqual.equalTo(3));
    }

    @Test
    public void deleteTest() {
	list.add("1");
	list.add("2");
	list.remove(0);

	Assert.assertThat(list.size(), IsEqual.equalTo(1));
    }

    @Test
    public void searchTest() {
	list.add("first");
	list.add("2nd");
	list.add("third");
	Assert.assertTrue(list.contains("third"));
	Assert.assertFalse(list.contains("bla bla bla"));

    }
    
    
}
