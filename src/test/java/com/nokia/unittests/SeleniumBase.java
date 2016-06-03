package com.nokia.unittests;

import static org.junit.Assert.fail;

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

	protected static final By PROFILE_BUTTON = By.xpath("//a[@class=\"masterbar__item masterbar__item-me\"]");
//	protected static final By LOGOUT_BUTTON = By.xpath("//button[@class=\"masterbar__item masterbar__item-me\"]");
	protected static final By LOGOUT_BUTTON = By.xpath("/html/body/div[2]/div/div[2]/div[2]/ul/div[2]/button");

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

	protected void logOut() {
		waitForElement(PROFILE_BUTTON);
		click(PROFILE_BUTTON);
		waitForElement(LOGOUT_BUTTON);
		click(LOGOUT_BUTTON);
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

	protected void insertTextByXpath(String elementXpath, String elementValue) {
		driver.findElement(By.xpath(elementXpath)).clear();
		driver.findElement(By.xpath(elementXpath)).sendKeys(elementValue);
	}

	private void open(String path) {
		driver.get(baseUrl + path);
	}

	protected void click(By identifier) {
		driver.findElement(identifier).click();
	}

//	private void waitForElement(By identifier) throws InterruptedException {
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(identifier)) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
//	}

	protected void waitForElement(By identifier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
	}

}