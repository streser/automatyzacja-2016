package testautomation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.*;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)

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
	@Parameters({"1234567890","123-456-7890","123-456-7890 x1234","123-456-7890 ext1234","(123)-456-7890","123.456.7890","123 456 7890"})
	public void shouldValidatePhone(String number) {
		Assert.assertTrue(phval.validatePhoneNumber(number));
	}
	@Test
	@Parameters({"8knd8","11-.2of","xsdwer3  ","    ","\n","%","@"})
	public void shouldnotValidatePhone(String number) {
		Assert.assertFalse(phval.validatePhoneNumber(number));
	}
	
}
