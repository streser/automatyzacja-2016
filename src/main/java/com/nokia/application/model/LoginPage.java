package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

	private String baseUrl = "https://pl.wordpress.com";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public PostsPage logIn(String user, String password) {
		open(baseUrl + "/");
		click(By.linkText("Zaloguj się"));
		insertText("user_login", user);
		insertText("user_pass", password);
		click(By.id("rememberme"));
		click(By.id("wp-submit"));
		return new PostsPage(driver);
	}

}
