package com.nokia.model;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Page {
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void insertText(String user, String identifier) {
		driver.findElement(By.id(identifier)).clear();
		driver.findElement(By.id(identifier)).sendKeys(user);
	}

	protected void insertTextByXPath(String text, String identifier) {
		driver.findElement(By.xpath(identifier)).clear();
		driver.findElement(By.xpath(identifier)).sendKeys(text);
	}
	
	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	protected void waitForElement(String path) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath(path)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	protected void waitForElementByLinkText(String path) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.linkText(path)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	
	protected void click(By by) {
		driver.findElement(by).click();
	}

	protected void open(String path) {
		driver.get(path);
	}
}
