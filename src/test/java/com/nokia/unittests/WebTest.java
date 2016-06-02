package com.nokia.unittests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class WebTest extends SeleniumBase {

	@Test
	public void userWithCorrectCredentialsIsSuccessfullyLogedIn() throws Exception {
		openLogInForm();
		logIn("szkolenieautomatyzacja", "qw12qw12");

		assertThatLogInWasSuccessful();
		logOut();
	}

	private void assertThatLogInWasSuccessful() {
		assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
	}

}
