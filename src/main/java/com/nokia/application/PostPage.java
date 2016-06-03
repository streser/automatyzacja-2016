package com.nokia.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends Page {

	public PostPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void addNewPost(String string) {
			click(By.className("masterbar__item-new"));
			insertText(By.className("form-text-input"), string);
		}
		
	public BlogPage goBlogPage() {
		final String NEW_POST_URL = "https://automatyzacjacs.wordpress.com";
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.className("notice__action"));
		driver.get(NEW_POST_URL);
		
		// TODO Auto-generated method stub
		return new BlogPage(driver);
	}

}

