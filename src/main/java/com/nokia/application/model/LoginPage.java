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
	// TODO Auto-generated method stub
	openUrl(START_PAGE);
	click(By.className("click-wpcom-login"));
	insertTextInto("user_login", WP_LOGIN);
	insertTextInto("user_pass", WP_PASS);
	click(By.id("wp-submit"));
	assertLoginSuccessfull();
	return new PostPage(driver);
    }

    private void assertLoginSuccessfull() throws InterruptedException {
	waitForElement(By.cssSelector("svg.gridicon.gridicons-user-circle"));
    }

}
