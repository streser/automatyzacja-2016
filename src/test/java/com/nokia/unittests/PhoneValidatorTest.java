package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;


@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {

	PhoneValidator validPLS;

	@Before
	public void setUP1() {
		System.out.println("Prepare1");
		validPLS = new PhoneValidator();
	}

	@Test
	@Parameters ({"123-456-7890","123-456-7890","123-456-7890","(123)-456-7890"})
	public void checkPhoneNumber(String gotNbr) throws Exception {

		Assert.assertEquals(validPLS.validatePhoneNumber(gotNbr), true);

	}
	
	@Before
	public void setUP2() {
		System.out.println("Prepare2");
		validPLS = new PhoneValidator();
	}

	@Test
	@Parameters ({"bcc","abc","def","afdfasdfa"})
	public void checkNoPhoneNumber(String gotNbr) throws Exception {

		Assert.assertEquals(validPLS.validatePhoneNumber(gotNbr), false);

	}

}
