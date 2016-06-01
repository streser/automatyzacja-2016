package com.nokia.unittests;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class FirstJUnitTest {
	
	@Test
	public void should(){
		System.out.println("Hello world");
		Assert.assertThat("hello", IsEqual.equalTo("hello"));
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("start");
//
		System.out.println("in progress...");
//
		System.out.println("stop");
	}
}


// given
// when
// then

//@Before
//@After