package com.nokia.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
	private String baseUrl;

	public LoginPage(WebDriver driver, String baseUrl) {
		super(driver);
		this.baseUrl = baseUrl;
	}

	public PostListPage login(String user, String pass) {
		openLogIn();
		insertText(user, "user_login");
		insertText(pass, "user_pass");
		click(By.id("wp-submit"));
		return new PostListPage(driver);
	}

	private void openLogIn() {
		open(baseUrl + "/");
		click(By.linkText("Zaloguj się"));
	}
}
