package com.nokia.ravs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page{

	public BlogPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean checkPostAdded(String title) throws InterruptedException {
		open("https://automatyzacjacs.wordpress.com/");
		waitForElementLinkText(title);
		return isElementPresent(By.linkText(title));
	}

}
