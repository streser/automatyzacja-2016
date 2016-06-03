package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
	private String baseUrl = "https://pl.wordpress.com/";
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Zaloguj się")).click();
	}

	public PostsPage logIn(String login, String password) {
		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);
		click(By.id("wp-submit"));
		return new PostsPage(driver);
	}

}
