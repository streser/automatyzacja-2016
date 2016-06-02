package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorParamsTest {

	@Test
	@Parameters({"123-456-7890","1234567890","123-456-7890 x1234","123-456-7890 ext1234","(123)-456-7890","123.456.7890","123 456 7890"})
	public void shouldValidatePhoneNo(String PhoneNo) {
		//when
		boolean result = new PhoneValidator().validatePhoneNumber(PhoneNo);
		System.out.println(PhoneNo + " - " + result);

		//then
		Assert.assertTrue(result);
	}

	@Test
	@Parameters({"123-456-789090","asfxasdfn","123-456-7890 x1234345","123-456-7890 et1234","123-(456)-7890","123.456.78.90"})
	public void shouldInvalidatePhoneNo(String PhoneNo) {
		//when
		boolean result = new PhoneValidator().validatePhoneNumber(PhoneNo);
		System.out.println(PhoneNo + " - " + result);

		//then
		Assert.assertFalse(result);
	}

}
