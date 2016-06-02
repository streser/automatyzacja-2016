package com.nokia.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class FirstSeleniumTest extends SeleniumBase {
	@Test
	public void checkElementName() throws Exception {
		openLoginForm();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		assertThatLoginWasSuccessful();
		logOut();
	}

	private void assertThatLoginWasSuccessful() {
		assertEquals("Welcome to the Reader", driver.findElement(By.cssSelector("h2.empty-content__title")).getText());
	}
}
