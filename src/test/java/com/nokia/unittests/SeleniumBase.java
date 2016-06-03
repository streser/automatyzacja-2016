package com.nokia.unittests;

import static org.junit.Assert.fail;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SeleniumBase {

	private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("(//button[@type='submit'])[2]");
	protected WebDriver driver;
	protected String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public String randomName() {

		return UUID.randomUUID().toString();
	}

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
	
	public void waitForElement(By identifier) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
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
		insertText(password, By.id("user_pass"));
		click(By.id("wp-submit"));
	}

	protected void insertText(String text, By identifier) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}

	protected void click(By identifier) {
		driver.findElement(identifier).click();
	}

	protected void open(String path) {
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