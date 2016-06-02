package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {
	
	private PhoneValidator phoneValidator;
	
	@Before
	public void initialize() {
		
		phoneValidator = new PhoneValidator();
	}
	
	@Test
	@Parameters({"1234567890", 
     			  "123-456-7890",
     			  "123-456-7890 x1234",
     			  "123-456-7890",
     			  "(123)-456-7890"})
	public void testValidNumber(String phoneNumber)
	{		
		Assert.assertTrue(phoneValidator.validatePhoneNumber(phoneNumber));
		
	}
	
	@Test
	@Parameters({"1234567", 
		  "123-456--7890",
		  "123-456-x7890 x1234",
		  "123-4-7890",
		  "(123-456-7890"})
	public void testInvalidNumber(String phoneNumber)
	{
		Assert.assertFalse(phoneValidator.validatePhoneNumber(phoneNumber));
		
	}

}
