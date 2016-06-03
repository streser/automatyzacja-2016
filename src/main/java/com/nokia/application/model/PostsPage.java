package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostsPage extends Page {

	public PostsPage(WebDriver driver) {
		super(driver);
	}

	public AddNewPostPage goToAddNewPost() {
		waitForElement(By.className("masterbar__item-new"));
		click(By.className("masterbar__item-new"));
		return new AddNewPostPage(driver);
	}

	public MySite goToMySite() {
		waitForElement(By.className("masterbar__item-content"));
		click(By.className("masterbar__item-content"));
		return new MySite(driver);
	}

}
