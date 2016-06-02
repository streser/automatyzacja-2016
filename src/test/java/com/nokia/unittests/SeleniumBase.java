package com.nokia.unittests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class  SeleniumBase {

	private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("(//button[@type='submit'])[2]");
	protected WebDriver driver;
	protected String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		// baseUrl = "https://pl.wordpress.com/";
		baseUrl = "https://pl.wordpress.com";
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void logOut() throws InterruptedException {
		driver.findElement(By.cssSelector("img.gravatar")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(LOGOUT_BUTTON_LOCATOR))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		driver.findElement(LOGOUT_BUTTON_LOCATOR).click();
	}

	protected void logIn(String login, String password) {
		open("/");
		click(By.linkText("Zaloguj się"));
		insertText(login, By.id("user_login"));
		insertText(password,By.id("user_pass"));
		click(By.id("wp-submit"));
	}

	private void insertText(String text, By identifier) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}

	private void click(By identifier) {
		driver.findElement(identifier).click();
	}

	private void open(String path) {
		driver.get(baseUrl + path);
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