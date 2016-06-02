package com.nokia.unittests;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneValidatorTest {

	PhoneValidator validPLS;

	@Before
	public void setUP1() {
		System.out.println("Prepare");
		validPLS = new PhoneValidator();
	}

	@Test
	public void checkPhoneNumber() {

		Assert.assertEquals(validPLS.validatePhoneNumber("1234567890"), true);

	}
	
	@Before
	public void setUP2() {
		System.out.println("Prepare");
		validPLS = new PhoneValidator();
	}

	@Test
	public void checkNoPhoneNumber() {

		Assert.assertEquals(validPLS.validatePhoneNumber("abcdefg0"), false);

	}

}
