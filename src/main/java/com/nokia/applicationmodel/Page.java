package com.nokia.applicationmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	protected void insertText(String text, By identifier) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}

	protected void click(By identifier) {
		driver.findElement(identifier).click();
	}
	
	public void waitForElement(By identifier) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
	}

}
