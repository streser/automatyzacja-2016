package testautomation;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class PhoneValidatorTest {
	@Test
	public void shouldValidatePhoneNumber() {
		PhoneValidator pv = new PhoneValidator();
//		Phone number 1234567890 validation result: true
//	    Phone number 123-456-7890 validation result: true
//	    Phone number 123-456-7890 x1234 validation result: true
//	    Phone number 123-456-7890 ext1234 validation result: true
//	    Phone number (123)-456-7890 validation result: true
//	    Phone number 123.456.7890 validation result: true
//	    Phone number 123 456 7890 validation result: true
		Assert.assertEquals(true, pv.validatePhoneNumber("1234567890"));
		Assert.assertEquals(true, pv.validatePhoneNumber("123-456-7890"));
		Assert.assertEquals(true, pv.validatePhoneNumber("123-456-7890 x1234"));
		Assert.assertEquals(true, pv.validatePhoneNumber("123-456-7890 ext1234"));
		Assert.assertEquals(true, pv.validatePhoneNumber("(123)-456-7890"));
		Assert.assertEquals(true, pv.validatePhoneNumber("123.456.7890"));
		Assert.assertEquals(true, pv.validatePhoneNumber("123 456 7890"));
		Assert.assertEquals(false, pv.validatePhoneNumber("123 456 7890 askldasdl"));
	}
}
