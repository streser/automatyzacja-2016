package testautomation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {
	
	PhoneValidator pv = new PhoneValidator();
	
	@Test
	@Parameters({
		"1234567890",
		"123-456-7890",
		"123-456-7890 x1234",
		"123-456-7890 ext1234",
		"(123)-456-7890",
		"123.456.7890"
		})
	public void shouldValidatePhoneNumber(String number) {
		
//		Phone number 1234567890 validation result: true
//	    Phone number 123-456-7890 validation result: true
//	    Phone number 123-456-7890 x1234 validation result: true
//	    Phone number 123-456-7890 ext1234 validation result: true
//	    Phone number (123)-456-7890 validation result: true
//	    Phone number 123.456.7890 validation result: true
//	    Phone number 123 456 7890 validation result: true
		Assert.assertEquals(true, pv.validatePhoneNumber(number));
	}
	
	@Test
	@Parameters({
		"",
		"       ",
		"askmklasmkasckm",
		"123-456-7890 ext1234 asdmaskmd",
		"xxx",
		"1"
		})
	public void shouldFailValidatePhoneNumber(String number) {
		Assert.assertEquals(false, pv.validatePhoneNumber(number));
	}
}
