package testautomation;

import org.junit.Assert;
import org.junit.Test;

public class PhoneValidatorTest {

	 /*
    Phone number 1234567890 validation result: true
    Phone number 123-456-7890 validation result: true
    Phone number 123-456-7890 x1234 validation result: true
    Phone number 123-456-7890 ext1234 validation result: true
    Phone number (123)-456-7890 validation result: true
    Phone number 123.456.7890 validation result: true
    Phone number 123 456 7890 validation result: true
     */
	PhoneValidator phval = new PhoneValidator ();
	
	@Test
	
	public void shouldValidatePhone() {
		Assert.assertEquals(true, phval.validatePhoneNumber("1234567890"));
		Assert.assertEquals(false, phval.validatePhoneNumber("1234jnijijni"));
	}
	
}
