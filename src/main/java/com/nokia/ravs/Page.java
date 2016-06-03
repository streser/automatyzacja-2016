package com.nokia.ravs;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class Page {

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;

	}

	public void open(String url) {
		driver.get(url);
	}

	public void click(By identifier) {
		driver.findElement(identifier).click();
	}

	public void waitForElementLinkText(String identifier) throws InterruptedException {
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

	public void waitForElementXPath(String identifier) throws InterruptedException {
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

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void insertTextByXpath(String text, String identifier) {
		driver.findElement(By.xpath(identifier)).clear();
		driver.findElement(By.xpath(identifier)).sendKeys(text);
	}

}
