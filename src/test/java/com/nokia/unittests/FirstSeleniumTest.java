package com.nokia.unittests;

import static org.junit.Assert.*;

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
		assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));

	}
}
