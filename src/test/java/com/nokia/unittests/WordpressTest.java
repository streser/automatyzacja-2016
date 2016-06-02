package com.nokia.unittests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class WordpressTest extends SeleniumBase {

	@Test
	public void userWithCorrectCredentialsLoggedSuccessfully() throws Exception {
		openLogInForm();

		logIn("szkolenieautomatyzacja", "qw12qw12");

		assertThatLogInWasSuccessful();
		logOut();
	}

	private void assertThatLogInWasSuccessful() {
		assertTrue(isElementPresent(By.linkText("Get recommendations on who to follow")));
	}
}