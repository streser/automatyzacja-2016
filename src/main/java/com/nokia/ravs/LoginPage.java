package com.nokia.ravs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public PostsPage login() {
		openLogIn();
		webLogin("szkolenieautomatyzacja", "qw12qw12");
		return new PostsPage(driver);
	}
	
	protected void openLogIn() {
		click(By.linkText("Zaloguj się"));
	}
	protected void webLogin(String user, String password) {

		insertText(user, "user_login");
		insertText(password, "user_pass");

		click(By.id("wp-submit"));
	}
	private void insertText(String user, String identifier) {
		driver.findElement(By.id(identifier)).clear();
		driver.findElement(By.id(identifier)).sendKeys(user);
	}
}
