package com.selenium;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;

public class InsertNewPost extends SeleniumBase {
	private static final String POST_ADDED_MSG = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/span/a";
	private static final String ADD_POST_BUTTON = "/html/body/div[2]/div/header/a[3]";
	private static final String PUBLISH_POST_BUTTON = "//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]";
	//private static final String BODY_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea";
	private static final String TITLE_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input";
	private String post_title;

	@Test
	public void AddingNewPost() throws Exception {
		post_title="MarekP" + randomName();
		openLogIn();
		webLogin("szkolenieautomatyzacja", "qw12qw12");
		checkIfLoginSuccessful();
		AddPost(post_title);
		checkIfPostAdded(post_title);
		//webLogOut();
	}

	private void AddPost(String title) throws InterruptedException {
		click(By.xpath(ADD_POST_BUTTON));
		waitForElementXPath(TITLE_FIELD);
		insertTextByXpath(title, TITLE_FIELD);
		//insertTextByXpath(title + randomName(), BODY_FIELD);
		insertTextByXpath(title, TITLE_FIELD);
		click(By.xpath(PUBLISH_POST_BUTTON));

	}
	

	private void checkIfPostAdded(String title) throws InterruptedException {
		waitForElementXPath(POST_ADDED_MSG);
		open("https://automatyzacjacs.wordpress.com/");
		waitForElementLinkText(title);
		assertTrue(isElementPresent(By.linkText(title)));
	}

	private void insertTextByXpath(String text, String identifier) {
		driver.findElement(By.xpath(identifier)).clear();
		driver.findElement(By.xpath(identifier)).sendKeys(text);
	}

}
