package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
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
	public void checkThatNumber1234567890IsOK() {
		Assert.assertTrue(phoneValidator.validatePhoneNumber("1234567890"));
	}

	@Test
	@Parameters({ "01234", "", "abcdefg", "---", ";.jk" })
	public void checkThatNumberIsWrong(String value) {
		Assert.assertFalse(phoneValidator.validatePhoneNumber(value));
	}

	@Test
	@Parameters({ "1234567890", "(123)-456-7890", "123 456 7890", "123.456.7890", "123-456-7890 x1234" })
	public void checkThatNumberIsOK(String value) {
		Assert.assertTrue(phoneValidator.validatePhoneNumber(value));
	}

}
