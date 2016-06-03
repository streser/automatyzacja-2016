package com.nokia.testautomation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostViewPage extends Page{

	public PostViewPage(WebDriver driver) {
		super(driver);
	}

	public boolean isPostPresent(String postTitle) throws Exception {
		WebElement postTitleCheckElement = findElementByLinkText(postTitle);		
		
		return postTitleCheckElement != null;
	}

}
