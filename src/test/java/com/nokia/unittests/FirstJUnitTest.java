package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstJUnitTest {
	
	List<String> list;
	@Before //odpalany przed KAZDYM testem, @BeforeClass odpalany RAZ przed cala seria testow 
	public void initializeList() {
		list = new ArrayList<String>();
		
		
	}
	
	
	@Test
	public void testAddList() {
		
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		Assert.assertTrue(list.contains("test1") && list.contains("test2") && list.contains("test3"));
		
		
	}
	
	@Test
	public void testIndexList() {
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		Assert.assertTrue(list.get(0) == "test1");
		
	}
	
	@Test
	public void testRemoveList() {
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.remove("test1");
		Assert.assertFalse(list.contains("test1"));
		
	}
	
	

}
