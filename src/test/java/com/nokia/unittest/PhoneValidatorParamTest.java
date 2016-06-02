// 2016-06-01
package com.nokia.unittest;

import static org.junit.Assert.assertEquals;

import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorParamTest {

    private static PhoneValidator validator;

    @BeforeClass
    public static void initTests() {
	validator = new PhoneValidator();
    }

    @Test
    @Parameters({ "0666555444, true", "test test, false" })
    public void testPhone(String phone, boolean status) {
	assertEquals(validator.validatePhoneNumber(phone), status);
    }

}
