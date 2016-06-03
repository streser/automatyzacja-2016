package com.nokia.application;

import org.openqa.selenium.*;

public class LoginPage extends PageObjectPattern {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open(String path) {
		driver.get(baseUrl+path);
	}

	public PostPage login(String login, String password) {

		click(By.className("click-wpcom-login"));
	    insertText(By.id("user_login"), login);
	    insertText(By.id("user_pass"), password);
	    click(By.id("wp-submit"));
		return new PostPage(driver);
	}
	
}