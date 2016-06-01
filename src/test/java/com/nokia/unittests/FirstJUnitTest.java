package com.nokia.unittests;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class FirstJUnitTest {

/*
 * @BeforeClass + public static void
 * @AfterClass
 * 
 * @Before
 * @After
 * 
 */
	
	@Test
	public void myTest() {
		//given - setup warunkow poczatkowych (przejscie na odpowiednia strone web)
		System.out.println("Hello World");

		//when - przedmiot testowania

		//then
		Assert.assertThat("hello", IsEqual.equalTo("world"));
	}
	
}
