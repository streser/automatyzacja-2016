package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class PhoneValidatorTest {

	PhoneValidator phoneValidator;

	@Before
	public void setUp() {
		phoneValidator = new PhoneValidator();
	}

	@Test
	public void checkThatNumberBeginningWithZeroIsWrong() {
		Assert.assertFalse(phoneValidator.validatePhoneNumber("01234"));
	}

	@Test
	public void checkThatNumberIsOK() {
		Assert.assertTrue(phoneValidator.validatePhoneNumber("1234567890"));
	}

}
