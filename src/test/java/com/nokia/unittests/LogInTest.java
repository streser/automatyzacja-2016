package com.nokia.unittests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class LogInTest extends SeleniumBase {

	private static final By HEADER_TEXT = By.xpath("//header[@id='header']/a[2]/span");

	@Test
	public void userWithCorrectCredentialsIsSuccessfullyLogedIn() throws Exception {
		openLogInForm();
		logIn("szkolenieautomatyzacja", "qw12qw12");

		assertThatLogInWasSuccessful();
		logOut();
	}



	private void assertThatLogInWasSuccessful() {
		assertTrue(isElementPresent(HEADER_TEXT));
	}

}
