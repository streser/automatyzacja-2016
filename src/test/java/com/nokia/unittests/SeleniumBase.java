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

public class SeleniumBase {

	private static final String LOGOUT_BUTTON_LOCATOR = "(//button[@type='submit'])[2]";
	protected WebDriver driver;
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
		open("/");
		driver.findElement(By.linkText("Zaloguj się")).click();
	}

	public void open(String path) {
		driver.get(baseUrl + path);
	}

	public void openPage(String url) {
		driver.get(url);
	}

	protected void logOut() throws InterruptedException {
		driver.findElement(By.cssSelector("img.gravatar")).click();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath(LOGOUT_BUTTON_LOCATOR)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		click(By.xpath(LOGOUT_BUTTON_LOCATOR));
	}

	public void click(By identifier) {
		driver.findElement(identifier).click();
	}

	protected void logIn(String login, String password) {
		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);
		click(By.id("wp-submit"));
	}

	public void insertText(By identifier, String text) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}

	public String randomName() {
		return UUID.randomUUID().toString();
	}

	public void waitForElement(By identifier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
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