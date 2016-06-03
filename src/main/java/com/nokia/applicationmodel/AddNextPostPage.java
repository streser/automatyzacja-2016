package com.nokia.applicationmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNextPostPage extends MenuPage{

	public AddNextPostPage(WebDriver driver) {
		super(driver);
	}

	public void addNextPost(String title) {
		click(By.className("editor-ground-control__publish-button"));
		insertText(title, By.className("form-text-input"));
		click(By.className("editor-ground-control__publish-button"));
		
		
	}

	public PostPage goToPostsPage() {
		waitForElement(By.linkText("automatyzacjacs"));
		return new PostPage(driver);
	}

}
