package com.nokia.testautomation.integrationtestPageObjPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
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
