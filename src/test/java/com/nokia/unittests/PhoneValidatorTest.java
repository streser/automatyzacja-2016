package com.nokia.unittests;

import org.junit.*;
import testautomation.PhoneValidator;

public class PhoneValidatorTest {
	PhoneValidator phoneVal = new PhoneValidator();	
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void validatePhoneNumber() {
        Assert.assertEquals(true, phoneVal.validatePhoneNumber("1234567890"));
        Assert.assertEquals(false, phoneVal.validatePhoneNumber("1234jnijijni"));
 }

}
