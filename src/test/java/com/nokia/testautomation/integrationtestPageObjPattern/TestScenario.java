package com.nokia.testautomation.integrationtestPageObjPattern;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScenario {
	WebDriver driver;

	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
