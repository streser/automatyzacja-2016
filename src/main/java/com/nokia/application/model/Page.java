package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By identifier) {
		driver.findElement(identifier).click();
	}

	public void open(String path) {
		driver.get(path);
	}

	public void insertText(String elementId, String elementValue) {
		driver.findElement(By.id(elementId)).clear();
		driver.findElement(By.id(elementId)).sendKeys(elementValue);
	}

	public void insertTextByXpath(String elementXpath, String elementValue) {
		driver.findElement(By.xpath(elementXpath)).clear();
		driver.findElement(By.xpath(elementXpath)).sendKeys(elementValue);
	}

	public void waitForElement(By identifier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
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
