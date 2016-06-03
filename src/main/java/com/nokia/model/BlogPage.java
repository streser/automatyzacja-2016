package com.nokia.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page {

	public BlogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean hasPost(String title) throws InterruptedException {
		open("https://automatyzacjacs.wordpress.com");
		waitForElementByLinkText(title);
		return isElementPresent(By.linkText(title));
	}

}
