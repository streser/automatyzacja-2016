package com.nokia.unittests;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

@SuppressWarnings("unused")
public class selenium1 extends seleniumSuperClass {
	@Test
	public void shouldLogIn() throws Exception {
		openWebPage(baseUrl);
		logIn("szkolenieautomatyzacja", "qw12qw12");
		logOut();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
