package com.nokia.unittests;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;
import org.openqa.selenium.By;

public class AddNewPostTest extends SeleniumBase {

	private static final By NEW_POST_BUTTON = By.xpath("//a[@class=\"masterbar__item masterbar__item-new\"]");
	private static final String POST_TITLE_TEXT_BOX_XPATH = "//input[@class=\"editor-title__input form-text-input\"]";
	private static final By PUBLISH_BUTTON = By.xpath("//button[@class=\"editor-ground-control__publish-button button is-primary\"]");
	private static final By PROFILE_BUTTON = By.xpath("/html/body/div[6]/div/ul[2]/li[2]/a");
	private static final By LOGOUT_BUTTON = By.xpath("//button[@class=\"ab-sign-out\"]");

	@Test
	public void shouldCreateNewPostAndVerifyCreation() throws Exception {
		openLogInForm();
		logIn("szkolenieautomatyzacja", "qw12qw12");

		String title = randomName();
		addPost(title);

		validatePostCreated(title);
		logOut();
	}



	public String randomName() {
		return UUID.randomUUID().toString() + " by Przemek K";
	}

	protected void addPost(String text) throws InterruptedException {
		click(NEW_POST_BUTTON);
		insertTextByXpath(POST_TITLE_TEXT_BOX_XPATH, text);
		click(PUBLISH_BUTTON);
		waitForElement(By.linkText("automatyzacjacs"));
	}

	protected void validatePostCreated(String text) throws InterruptedException {
		driver.get("https://automatyzacjacs.wordpress.com/");
		waitForElement(By.linkText(text));
		assertTrue(isElementPresent(By.linkText(text)));
	}

	@Override
	protected void logOut() {
		waitForElement(PROFILE_BUTTON);
		click(PROFILE_BUTTON);
		waitForElement(LOGOUT_BUTTON);
		click(LOGOUT_BUTTON);
	}

}
