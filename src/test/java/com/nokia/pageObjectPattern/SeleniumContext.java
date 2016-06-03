package com.nokia.pageObjectPattern;

import static org.junit.Assert.fail;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class SeleniumContext {
	protected WebDriver driver;
	protected String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	protected void logOut() throws InterruptedException {
//		click(By.cssSelector("img.gravatar"));
//		waitForElement("(//button[@type='submit'])[2]");
//		click(By.xpath("(//button[@type='submit'])[2]"));
//	}

	public String randomName() {
		return UUID.randomUUID().toString();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
