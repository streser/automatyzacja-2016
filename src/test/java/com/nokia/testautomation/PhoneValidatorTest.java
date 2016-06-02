package com.nokia.testautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {
	
	PhoneValidator phonevalid;
	
	@Before
	public void setUp(){
		phonevalid = new PhoneValidator();
	}
	@Test
	@Parameters({"1234567890", "123-456-7890", "123-456-7890 x1234", "123-456-7890 ext12345" })
	public void validateCorrectPhoneNumber(String number){
		Assert.assertTrue(phonevalid.validatePhoneNumber(number));
	}
	@Test
	@Parameters({"", "123-456-7890 12", "123-456?7890", "123-456-7890 ext123456" })
	public void validateIncorrectPhoneNumber(String number){
		Assert.assertFalse(phonevalid.validatePhoneNumber(number));
	}
	
	
}
