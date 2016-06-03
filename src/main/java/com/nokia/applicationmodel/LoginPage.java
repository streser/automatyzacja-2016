package com.nokia.applicationmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
	
	protected String baseUrl;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		open("/");
		click(By.linkText("Zaloguj się"));

		
	}

	private void open(String path) {
		baseUrl = "https://pl.wordpress.com";
		driver.get(baseUrl + path);
		
	}
	
	protected void click(By identifier) {
		driver.findElement(identifier).click();
	}
	
	protected void insertText(String text, By identifier) {
		driver.findElement(identifier).clear();
		driver.findElement(identifier).sendKeys(text);
	}

	public PostPage login(String login, String password) {
		// TODO Auto-generated method stub
		insertText(login, By.id("user_login"));
		insertText(password, By.id("user_pass"));
		click(By.id("wp-submit"));
		return new PostPage(driver);
	}

}
