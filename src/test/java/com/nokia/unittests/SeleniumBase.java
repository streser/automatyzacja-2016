package com.nokia.unittests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void openLogInForm() {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Zaloguj się")).click();
	}

	private void inputText(String elementId, String elementValue) {
		driver.findElement(By.id(elementId)).clear();
		driver.findElement(By.id(elementId)).sendKeys(elementValue);
	}

	protected void logOut() throws InterruptedException {
		driver.findElement(By.cssSelector("img.gravatar")).click();
		waitForElement("description");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}

	protected void logIn(String user, String password) {
		inputText("user_login", user);
		inputText("user_pass", password);
		driver.findElement(By.id("rememberme")).click();
		driver.findElement(By.id("wp-submit")).click();
	}

	private void waitForElement(String elementId) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id(elementId)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}