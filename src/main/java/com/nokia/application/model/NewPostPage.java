package com.nokia.application.model;

import org.openqa.selenium.WebDriver;

public class NewPostPage extends Page{

	public NewPostPage(WebDriver driver) {
		super(driver);
	}

	public PostsPage goToPostsPage() {
		driver.get("https://automatyzacjacs.wordpress.com/");
		return new PostsPage(driver);
	}

}
