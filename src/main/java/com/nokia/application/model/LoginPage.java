package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    private static final String START_PAGE = "https://wordpress.com";
    private static final String WP_LOGIN = "szkolenieautomatyzacja";
    private static final String WP_PASS = "qw12qw12";

    public LoginPage(WebDriver driver) {
	super(driver);
    }

    public PostPage logIn() throws InterruptedException {
	return logIn(WP_LOGIN, WP_PASS);
    }
    
    public PostPage logIn(String user, String pass) throws InterruptedException {
	try {
	openUrl(START_PAGE);
	click(By.className("click-wpcom-login"));
	insertTextInto("user_login", user);
	insertTextInto("user_pass", pass);
	click(By.id("wp-submit"));
	assertLoginSuccessfull();
	return new PostPage(driver);
	} catch(AssertionError e) {
	    return null;
	}
	
    }

    private void assertLoginSuccessfull() throws InterruptedException {
	waitForElement(By.cssSelector("svg.gridicon.gridicons-user-circle"));
    }

}
