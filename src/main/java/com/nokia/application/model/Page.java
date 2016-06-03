package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	private String baseUrl = "https://pl.wordpress.com";
	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open(String path) {
		driver.get(baseUrl + path);
	}

	public void click(By identifier) {
		driver.findElement(identifier).click();
	}
	
	protected void logIn(String login, String password) {
		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);
		click(By.id("wp-submit"));
	}

	public void insertText(By identifier, String text) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}
	
	public void waitForElement(By identifier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
	}
	
	public void openPage(String url) {
		driver.get(url);
	}
}
