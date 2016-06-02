package com.nokia.unittests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {

    @Test
    @Parameters({"1234567890", "123-456-7890"})
    public void shouldValidatePhone(String phoneNo) {
        Assert.assertTrue(new PhoneValidator().validatePhoneNumber(phoneNo));
    }

    @Test
    public void shouldFailPhoneNumberValidation() {
        boolean result = new PhoneValidator().validatePhoneNumber("3.456.7890");
        Assert.assertFalse(result);
    }
}
