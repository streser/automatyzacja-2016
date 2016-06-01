package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstJUnitTest {
	private List<String> values;
	
	@BeforeClass
	public void setUPClass() {
		System.out.println("Prepare class");
	}
	
	@Before
	public void setUP() {
		System.out.println("Prepare");
		values = new ArrayList<String>();
	}
	
	@Test
	public void shouldAddElements() {
		System.out.println("Run tet 1");
		
		values.add("element");
		Assert.assertThat(values.get(0), IsEqual.equalTo("element"));
	}
	
	@Test
	public void shouldRemoveElements() {
		System.out.println("Run test 2");
		values.add("element");
		values.remove(0);
		Assert.assertEquals(values.size(),0);
	}
	
	@After
	public void finishTest() {
		System.out.println("After test");
	}

}
