package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewPostPage extends Page {

	public AddNewPostPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void addNewPost(String postTitle) {
		waitForElement(By.className("form-text-input"));
		insertText(By.className("form-text-input"), postTitle);
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.linkText("automatyzacjacs"));
	}

	public BlogPage getToBlog() {
		driver.get("https://automatyzacjacs.wordpress.com/");
		return new BlogPage(driver);
	}

}
