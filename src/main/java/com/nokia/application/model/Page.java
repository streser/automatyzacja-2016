package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void insertText(By identifier, String text) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}
	
	protected void click(By identifier) {
		driver.findElement(identifier).click();
	}

	protected void waitForElement(By identifier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
	}

}
