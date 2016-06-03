package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPostPage extends Page{

	private static final By ADMIN_PANEL_BUTTON = By.xpath("/html/body/div[2]/div/header/a[1]");
	private static final By POST_LIST_BUTTON = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/ul/li[2]/ul/li[1]/a[1]");

	public NewPostPage(WebDriver driver) {
		super(driver);
	}

	public PostsPage goToPostsPage() {
		driver.get("https://automatyzacjacs.wordpress.com/");
		return new PostsPage(driver);
	}

	public PostsList goToPostsList() {
		click(ADMIN_PANEL_BUTTON);
		waitForElement(POST_LIST_BUTTON);
		click(POST_LIST_BUTTON);
		return new PostsList(driver);
	}

}
