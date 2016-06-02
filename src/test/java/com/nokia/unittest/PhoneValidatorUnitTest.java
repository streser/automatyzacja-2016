// 2016-06-01
package com.nokia.unittest;

import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneValidatorUnitTest {

    private static PhoneValidator validator;

    @BeforeClass
    public static void initTests() {
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
