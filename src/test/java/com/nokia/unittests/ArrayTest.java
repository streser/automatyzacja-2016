package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {

	private List<String> list;

	@Before
	public void setUp() {
		//given
		list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
	}

	@Test
	public void shouldAddElement() {
		//when
		list.add("element");

		//then
		Assert.assertThat(list.get(list.size() - 1), IsEqual.equalTo("element"));
	}

	@Test
	public void shouldRemoveElement() {
		//given
		list.add("element");

		//when
		list.remove(list.size() - 1);

		//then
		Assert.assertThat(list.get(list.size() - 1), IsEqual.equalTo("test3"));
	}

	@Test
	public void shouldFindElementUsingIndex() {
		//given
		list.add("element-1");
		list.add("element-2");
		System.out.println(list);

		//when
		String element = list.get(list.size() - 2);

		//then
		Assert.assertThat(element, IsEqual.equalTo("element-1"));
	}
}
