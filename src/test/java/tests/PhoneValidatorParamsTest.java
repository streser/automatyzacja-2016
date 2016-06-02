package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorParamsTest {

	private static PhoneValidator validator;

	@BeforeClass
	public static void initTests() {

		validator = new PhoneValidator();
	}

	@Test
	@Parameters({ "123-456-7890 x1234", "123-456-7890", "0666888222", "(123)-456-7890" })
	public void ParamsTestValid(String phonenumber) {
		Assert.assertTrue(validator.validatePhoneNumber(phonenumber));
	}

	@Test
	@Parameters({ "bla", "bla bla", "bla 123", "(123) bla" })
	public void ParamsTestInvalid(String phonenumber) {
		Assert.assertFalse(validator.validatePhoneNumber(phonenumber));
	}

}
