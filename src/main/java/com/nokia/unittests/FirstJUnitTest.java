package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstJUnitTest {

	private List<String> lista;
	/*
	@Test
	public void should() {
		System.out.println("hello");
		
		Assert.assertThat("hello", IsEqual.equalTo("world"));
	}
	*/
	
	@Before
	public void insertElementIntoList() {
		lista = new ArrayList<String>();
		System.out.println("Before the test: " + lista);
	}
	
	@Test
	public void isElementAdded() {
		lista.add("blada");
		Assert.assertThat(lista.get(0), IsEqual.equalTo("blada"));
		System.out.println("After the test of element addition: " + lista);
	}

	@Test
	public void isElementRemoved() {
		lista.add("pierwszy dodany");
		lista.remove(0);
		Assert.assertEquals(lista.size(), 0);
		System.out.println("After the test of element removal: " + lista);
	}

	@Test
	public void whatIsElementIndex() {
		lista.add("pierwszy");
		lista.add("drugi");
		lista.add("trzeci");
		Assert.assertThat(lista.get(1), IsEqual.equalTo("drugi"));
		System.out.println("After the test of element indexes: " + lista.get(1));
	}

}
