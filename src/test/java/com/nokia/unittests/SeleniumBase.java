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

	private static final String LOGOUT_BUTTON_LOCATOR = "(//button[@type='submit'])[2]";
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

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	protected void openLogInForm() {
		open("/");
		click(By.linkText("Zaloguj się"));
	}

	protected void logOut() throws InterruptedException {
		click(By.cssSelector("img.gravatar"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.id("description"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(LOGOUT_BUTTON_LOCATOR)).click();
	}

	protected void logIn(String user, String password) {
		insertText("user_login", user);
		insertText("user_pass", password);
		click(By.id("rememberme"));
		click(By.id("wp-submit"));
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private void insertText(String elementId, String elementValue) {
		driver.findElement(By.id(elementId)).clear();
		driver.findElement(By.id(elementId)).sendKeys(elementValue);
	}

	private void open(String path) {
		driver.get(baseUrl + path);
	}

	private void click(By identifier) {
		driver.findElement(identifier).click();
	}

}