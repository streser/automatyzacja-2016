package com.nokia.unittests;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class PhoneValidatorTest {
	
	private PhoneValidator phoneValidator;
	
	@Before
	public void initialize() {
		
		phoneValidator = new PhoneValidator();
	}
	
	@Test
	public void testValidNumber()
	{		
		Assert.assertTrue(phoneValidator.validatePhoneNumber("1234567890"));
		Assert.assertTrue(phoneValidator.validatePhoneNumber("123-456-7890"));
		Assert.assertTrue(phoneValidator.validatePhoneNumber("123-456-7890 x1234"));
	}
	
	@Test
	public void testInvalidNumber()
	{
		Assert.assertFalse(phoneValidator.validatePhoneNumber("123456789a"));
		Assert.assertFalse(phoneValidator.validatePhoneNumber("123-456-7890 xa1234"));
	}

}
