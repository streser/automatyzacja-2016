package com.nokia.testautomation.integrationtestPageObjPattern;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	protected String baseUrl = "https://pl.wordpress.com";
	
	public Page(WebDriver driver){
		this.driver = driver;
	}
	public void insertText(By id, String text) {
		driver.findElement(id).clear();
	    driver.findElement(id).sendKeys(text);
	}
	public void click(By id) {
		driver.findElement(id).click();
	}
	public String randomName(){
		return UUID.randomUUID().toString();
	}
	public void waitForElements(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
}
