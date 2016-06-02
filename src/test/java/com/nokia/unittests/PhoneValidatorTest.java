package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import testautomation.PhoneValidator;

@RunWith(JUnitParamsRunner.class)

public class PhoneValidatorTest {
	PhoneValidator phoneVal = new PhoneValidator();	

    /*
    Phone number 1234567890 validation result: true
    Phone number 123-456-7890 validation result: true
    Phone number 123-456-7890 x1234 validation result: true
    Phone number 123-456-7890 ext1234 validation result: true
    Phone number (123)-456-7890 validation result: true
    Phone number 123.456.7890 validation result: true
    Phone number 123 456 7890 validation result: true
    */
	
	@Test
	@Parameters({"1234567890, true", "123-456-789, false", "123-abc-456, false"})
	/*
	public void validatePhoneNumber() {
        Assert.assertEquals(true, phoneVal.validatePhoneNumber("1234567890"));
        Assert.assertEquals(false, phoneVal.validatePhoneNumber("1234jnijijni"));
	}
	*/
	public void shouldValidatePhoneNumber(String number, boolean valid) throws Exception {
        Assert.assertEquals(valid, phoneVal.validatePhoneNumber(number));
	}
	
	/* druga wersja od Marka */
    @Test
    @Parameters({"1234567890","123-456-7890","123-456-7890 x1234","123-456-7890 ext1234","(123)-456-7890","123.456.7890","123 456 7890"})
    public void shouldValidatePhone(String number) {
           Assert.assertTrue(phoneVal.validatePhoneNumber(number));
    }
    @Test
    @Parameters({"8knd8","11-.2of","xsdwer3  ","    ","\n","%","@"})
    public void shouldnotValidatePhone(String number) {
           Assert.assertFalse(phoneVal.validatePhoneNumber(number));
    }


}
