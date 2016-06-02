package com.nokia.testautomation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class SeleniumIDETest extends SeleniumBase {
	@Test
	public void userWithCorrectCredentialsIsSucessfullyLoggedIn() throws Exception {
		open("/");
		logIn("szkolenieautomatyzacja", "qw12qw12");
		assertThatLogInWasSuccesful();
		logOut();
	}

	public void assertThatLogInWasSuccesful() {
		assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
	}
}
