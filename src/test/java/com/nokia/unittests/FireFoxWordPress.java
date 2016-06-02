package com.nokia.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxWordPress {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		// baseUrl = "https://pl.wordpress.com/";
		baseUrl = "https://pl.wordpress.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAutomation() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Zaloguj się")).click();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		assertThatLoginWasSuccessful();
		logOut();

		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}

	private void logOut() throws InterruptedException {
		driver.findElement(By.cssSelector("img.gravatar")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("(//button[@type='submit'])[2]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	private void assertThatLoginWasSuccessful() {
		assertEquals("Welcome to the Reader", driver.findElement(By.cssSelector("h2.empty-content__title")).getText());
	}

	private void logIn(String login, String password) {
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys(login);
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}