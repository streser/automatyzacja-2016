package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class FirstJUnitTest {

/*
	@Test
	public void shouldl() {
		System.out.println("hello world");
	}
*/
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Jestem w @BeforeClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Jestem w @AfterClass");
	}
	
	@Before
	public void insertElementIntoTheList() {
		System.out.println("Jestem w @Before");
		List<String> lista = new ArrayList<String>();
		lista.add("Adam");
		lista.add("Michal");
		lista.add("Wojtek");
	
	}
	
	@Test
	public void checkInsertingIntoTheList() {
		System.out.println("Jestem w @Test");
		
	}
	
	
	
}
