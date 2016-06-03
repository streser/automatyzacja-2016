package com.nokia.application;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void open(String url) {
		driver.get(url + "/");
	}

	public void insertText(By element, String text) {
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(text);
	}

	public void click(By element) {
		driver.findElement(element).click();
	}
	
	protected void waitForElement(By selector) {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(selector))
					break;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
