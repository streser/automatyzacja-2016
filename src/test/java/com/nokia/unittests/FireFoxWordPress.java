package com.nokia.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class FireFoxWordPress extends SeleniumBase {
	@Test
	public void testAutomation() throws Exception {

		logIn("szkolenieautomatyzacja", "qw12qw12");
		assertThatLoginWasSuccessful();
		logOut();
	}

	private void assertThatLoginWasSuccessful() {
		assertEquals("Welcome to the Reader", driver.findElement(By.cssSelector("h2.empty-content__title")).getText());
	}

}