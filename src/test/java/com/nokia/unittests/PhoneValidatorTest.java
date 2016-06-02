package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import testautomation.PhoneValidator;

@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {

	@Test
	@Parameters({"abc, false", 
			    "012345678, false",
			    ", false",
			    "#,false",
			    "12345,false"})
	
	
	public void shouldFail(String str, boolean valid) throws Exception {
		Assert.assertEquals(valid, new PhoneValidator().validatePhoneNumber(str));
	}
	

	@Test
	@Parameters({"1234567890, true", 
	    "123-456-7890, true",
	    "123-456-7890 x1234, true",
	    "123-456-7890 ext1234, true",
	    "(123)-456-7890, true"})

	public void shouldPass(String str, boolean valid) throws Exception {
		Assert.assertEquals(valid, new PhoneValidator().validatePhoneNumber(str));
	}
}
