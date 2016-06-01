package com.nokia.testautomation;

import java.util.ArrayList;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstJUnitTest {
	public ArrayList<String> Lista1;
	
	@Before
	public void createList(){
		Lista1 = new ArrayList<String>();
		Lista1.add("Element1");
	}
	@Test
	public void addToList(){
		Lista1.add("Element1");
		Assert.assertFalse(Lista1.isEmpty());
	}
	@Test
	public void deleteFromList(){
		Lista1.remove(0);
		Assert.assertTrue(Lista1.isEmpty());
	}
	@Test
	public void searchList(){
		Lista1.add("Element1");
		Assert.assertThat(Lista1.get(0), IsEqual.equalTo("Element1"));
	}
}
