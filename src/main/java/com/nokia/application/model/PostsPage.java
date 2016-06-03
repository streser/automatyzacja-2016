package com.nokia.application.model;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostsPage extends Page{

	private static final By NEW_POST_BUTTON = By.xpath("//a[@class=\"masterbar__item masterbar__item-new\"]");
	private static final String POST_TITLE_TEXT_BOX_XPATH = "//input[@class=\"editor-title__input form-text-input\"]";
	private static final By PUBLISH_BUTTON = By.xpath("//button[@class=\"editor-ground-control__publish-button button is-primary\"]");
	private static final By PROFILE_BUTTON = By.xpath("/html/body/div[6]/div/ul[2]/li[2]/a");
	private static final By LOGOUT_BUTTON = By.xpath("//button[@class=\"ab-sign-out\"]");

	public PostsPage(WebDriver driver) {
		super(driver);
	}

	public NewPostPage addNewPost(String title) {
		click(NEW_POST_BUTTON);
		insertTextByXpath(POST_TITLE_TEXT_BOX_XPATH, title);
		click(PUBLISH_BUTTON);
		waitForElement(By.linkText("automatyzacjacs"));
		return new NewPostPage(driver);
	}

	public void assertThatNewPostCreated(String title) {
		waitForElement(By.linkText(title));
		assertTrue(isElementPresent(By.linkText(title)));
	}

	public void logOut() {
		waitForElement(PROFILE_BUTTON);
		click(PROFILE_BUTTON);
		waitForElement(LOGOUT_BUTTON);
		click(LOGOUT_BUTTON);
	}

}
