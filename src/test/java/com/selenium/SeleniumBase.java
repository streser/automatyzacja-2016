package com.selenium;

import static org.junit.Assert.fail;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
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
	private String title;
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
	
	public String randomName(){
		return UUID.randomUUID().toString();
	}
	
	public void AddPost() throws InterruptedException{
		title = "MarekP"+randomName();
		click(By.xpath("/html/body/div[2]/div/header/a[3]"));	
		waitForElementXPath("//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		insertTextByXpath(title,"//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		insertTextByXpath(title+randomName(), "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea");
		insertTextByXpath(title,"//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		click(By.xpath("//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]"));
		
		
	}

	public void checkIfPostAdded() throws InterruptedException{
		waitForElementXPath("//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/span/a");
		//waitForElementXPath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div");
		open("https://automatyzacjacs.wordpress.com/");
		waitForElementLinkText(title);
		assertTrue(isElementPresent(By.linkText(title)));
	}
	
	public void waitForElementXPath(String identifier) throws InterruptedException{
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath(identifier)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	
	
	public void waitForElementLinkText(String identifier) throws InterruptedException{
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.linkText(identifier)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	
	private void insertText(String user, String identifier) {
		driver.findElement(By.id(identifier)).clear();
		driver.findElement(By.id(identifier)).sendKeys(user);
	}

	private void insertTextByXpath(String text, String identifier) {
		driver.findElement(By.xpath(identifier)).clear();
		driver.findElement(By.xpath(identifier)).sendKeys(text);
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