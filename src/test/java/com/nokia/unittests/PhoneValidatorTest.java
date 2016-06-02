package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Test;

public class PhoneValidatorTest {
	
	@Test
	public void shouldValidatePhoneNo() {
		//when
		String correctPhoneNo = "123-456-7890";

		//then
		Assert.assertTrue(new PhoneValidator().validatePhoneNumber(correctPhoneNo));
	}

	@Test
	public void shouldInvalidatePhoneNo() {
		//when
		String incorrectPhoneNo = "asdginncmmacasmfjho";

		//then
		Assert.assertFalse(new PhoneValidator().validatePhoneNumber(incorrectPhoneNo));
	}

}
