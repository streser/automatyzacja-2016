package com.nokia.unittest;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;

public class FirstJUnitTest {

	static List<String> TestList = new ArrayList<String>();
	int listSize;
	
	@BeforeClass
	public static void AddList() {
		TestList.add("item_1");
		TestList.add("item_2");
		TestList.add("item_3");
		TestList.add("item_4");
	}
	
	@Test
	public void shouldElementAddedToList() {
		TestList.add("item_5");
		Assert.assertEquals("item_5", TestList.get(TestList.size()-1));
	}

	@Test
	public void shouldElementDeleteFromList() {
		int size = TestList.size();
		TestList.remove(TestList.get(TestList.size()-1));
		Assert.assertEquals(TestList.size(), size-1);
	}
	
}
