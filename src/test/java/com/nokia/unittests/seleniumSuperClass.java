package com.nokia.unittests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumSuperClass {

	protected WebDriver driver;
	protected String baseUrl;
	protected StringBuffer verificationErrors = new StringBuffer();

	public seleniumSuperClass() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void openWebPage(String url) {
		driver.get(url + "/");
	}

	public void insertText(By element, String text) {
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(text);
	}

	public void click(By element) {
		driver.findElement(element).click();
	}

	protected void logIn(String login, String password) {
		// driver.findElement(By.linkText("Zaloguj się")).click();
		// driver.findElement(By.className("click-wpcom-login")).click();
		click(By.className("click-wpcom-login"));

		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);
		// driver.findElement(By.id("wp-submit")).click();
		click(By.id("wp-submit"));
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// name=oktab04184930043155366 | ]]
		// assertEquals("Obserwowanie ‹ Reader — WordPress.com",
		// driver.getTitle());
	}

	protected void waitForElement(By selector) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(selector))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	protected void logOut() {
		// driver.findElement(By.cssSelector("img.gravatar")).click();
		click(By.cssSelector("img.gravatar"));

		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// name=oktab8235637659710296 | ]]
		click(By.xpath("(//button[@type='submit'])[2]"));
		// driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}

	protected boolean isElementPresent(By xpath) {
		try {
			driver.findElement(xpath);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}