package com.selenium;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
 

public class SeleniumTest extends SeleniumBase {
	@Test
	public void testAutomation() throws Exception {
		openLogIn();
		webLogin("szkolenieautomatyzacja", "qw12qw12");
		checkIfLoginSuccessful(); 
		webLogOut();
	}

	private void checkIfLoginSuccessful() {
		assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span"))); 
	}
}
