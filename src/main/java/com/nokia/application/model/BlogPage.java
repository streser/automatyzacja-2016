package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page {

	private static final String POST_TITLE_INPUT = "form-text-input";
	
	public BlogPage(WebDriver driver) {
		super(driver);
	}

	public void create(String postTitle) {
				publishPost(postTitle);
	}
	
	private void publishPost(String postTitle) {
		waitForElement(By.className(POST_TITLE_INPUT));
		insertText(By.className(POST_TITLE_INPUT), postTitle);
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.className("post-editor__notice"));
	}
	
	public void goToPostPage() {
		openPage("https://automatyzacjacs.wordpress.com");
	}

	public boolean hasPost(String postTitle) {
		boolean result = driver.findElement(By.className("cover-link")).getAttribute("href").contains(postTitle);
		return result;
	}

}
