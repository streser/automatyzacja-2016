package com.selenium;

import org.junit.*;

public class SeleniumTest extends SeleniumBase {
	@Test
	public void testAutomation() throws Exception {
		openLogIn();
		webLogin("szkolenieautomatyzacja", "qw12qw12");
		checkIfLoginSuccessful();
		webLogOut();
	}

}
