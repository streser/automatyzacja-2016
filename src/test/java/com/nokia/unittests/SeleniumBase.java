package com.nokia.unittests;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class SeleniumBase {

	private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("(//button[@type='submit'])[2]");
	protected WebDriver driver;
	private String baseUrl;
	private String path;
	private StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com";
		path = "/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void openLoginForm() {
		open(baseUrl + path);
		driver.findElement(By.linkText("Zaloguj się")).click();
	}

	private void open(String path) {
		driver.get(path);
	}

	protected void logOut() throws InterruptedException {	
		waitForElement(By.cssSelector("img.gravatar"));

		driver.findElement(By.cssSelector("img.gravatar")).click();
		waitForElement(LOGOUT_BUTTON_LOCATOR);

		driver.findElement(LOGOUT_BUTTON_LOCATOR).click();
	}

	private void waitForElement(By locator) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(locator))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	protected void logIn(String login, String password) throws InterruptedException {
		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);
		click(By.id("wp-submit"));
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.cssSelector("h2.empty-content__title")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	private void click(By identifier) {
		driver.findElement(identifier).click();
	}

	private void insertText(By identifier, String text) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
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