package com.nokia.pageobjectpattern;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScenario {
	protected WebDriver driver;

	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String randomName() {
		return UUID.randomUUID().toString();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
