package com.nokia.testautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneValidatorTest {
	
	PhoneValidator phonevalid;
	
	@Before
	public void setUp(){
		phonevalid = new PhoneValidator();
	}
	@Test
	public void validatePhoneNumberSimpleFormat(){
		String number = "1234567890";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberWithLines(){
		String number = "123-456-7890";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberExtensionLength3(){
		String number = "123-456-7890 x1234";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberExtensionLength5(){
		String number = "123-456-7890 ext1234";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberWithBraces(){
		String number = "(123)-456-7890";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberWithDots(){
		String number = "123.456.7890";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberWithSpaces(){
		String number = "123 456 7890";
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	public void validatePhoneNumberIncorrect(){
		String number = "123 456 7890 1";
		Assert.assertFalse(phonevalid.validatePhoneNumber(number));
	}
}
