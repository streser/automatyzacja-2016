package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class FirstJUnitTest {
	
	static List<String> list = new ArrayList<>();
	int startSize;
	
	@Before
	public void setSize() {
		startSize = list.size();
	}
	
	@BeforeClass
	public static void makeList() {
		list.add("asd");
		list.add("bec");
		list.add("cuq");
		list.add("dak");
	}
	
	@Test
	public void shouldElementBeAdded() {
		list.add("trytytyty");
		Assert.assertEquals(startSize+1, list.size());
	}
	
	@Test
	public void shouldElementBeDeleted() {
		list.remove(list.size()-1);
		Assert.assertEquals(startSize-1, list.size());
	}
	
	@Test
	public void shouldElementBeFound() {
		Assert.assertEquals("asd", list.get(0));
		Assert.assertEquals("asd_zle", list.get(0));
	}
}