package com.nokia.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
/*
	@SuppressWarnings("unused")
	private void PostPage(WebDriver WebDriver) {
		Page pp = new Page(WebDriver);
		// TODO Auto-generated method stub
		// return null;

	}
*/

	public void logIn(String login, String password) { 
		
		click(By.className("click-wpcom-login"));
		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);
		click(By.id("wp-submit"));
	}
}
