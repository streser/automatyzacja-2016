package com.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {

	protected WebDriver driver;
	protected String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void webLogOut() throws InterruptedException {
		click(By.cssSelector("img.gravatar"));
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
		click(By.xpath("(//button[@type='submit'])[2]"));
	}

	protected void webLogin(String user, String password) {

		insertText(user, "user_login");
		insertText(password, "user_pass");

		click(By.id("wp-submit"));
	}

	private void insertText(String user, String identifier) {
		driver.findElement(By.id(identifier)).clear();
		driver.findElement(By.id(identifier)).sendKeys(user);
	}

	private void open(String path) {
		driver.get(path);
	}

	protected void openLogIn() {
		open(baseUrl + "/");
		click(By.linkText("Zaloguj się"));
	}

	private void click(By identifier) {
		driver.findElement(identifier).click();
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