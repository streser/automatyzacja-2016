package com.nokia.testautomation;

import static org.junit.Assert.fail;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class SeleniumBase {

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

	public void logOut() throws InterruptedException {

		click(By.cssSelector("img.gravatar"));
		By logoutButton = By.xpath("(//button[@type='submit'])[2]");
	    waitForElement(By.xpath("(//button[@type='submit'])[2]"));
		click(logoutButton);
	}

	public void waitForElement(By id) throws InterruptedException {
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(id)) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}

	public void logIn(String login, String password) {

		click(By.className("click-wpcom-login"));
	    insertText(By.id("user_login"), login);
	    insertText(By.id("user_pass"), password);
	    click(By.id("wp-submit"));
	}

	public void click(By id) {
		driver.findElement(id).click();
	}

	public void insertText(By id, String text) {
		driver.findElement(id).clear();
	    driver.findElement(id).sendKeys(text);
	}

	public void open(String path) {
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
	public String randomName(){
		return UUID.randomUUID().toString();
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