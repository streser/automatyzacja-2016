package tests;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

public class PhoneValidatorTest {

	private static PhoneValidator validator;

	@BeforeClass
	public static void initTests () {
		
		validator = new PhoneValidator();
	}
	
	@Test
	public void testValid() {
		Assert.assertTrue(validator.validatePhoneNumber("0666888222"));
	}

	@Test
	public void testInvalid() {
		Assert.assertFalse(validator.validatePhoneNumber("bla bla bla"));
	}
}