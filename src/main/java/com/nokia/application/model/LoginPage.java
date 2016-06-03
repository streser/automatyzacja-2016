package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void openLoginPage() {
		open("/");
		driver.findElement(By.linkText("Zaloguj się")).click();
	}
	
	public PostsPage logIn() {
		logIn("szkolenieautomatyzacja", "qw12qw12");
		return new PostsPage(driver);
	}

}
