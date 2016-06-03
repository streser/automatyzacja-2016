package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page {

    public BlogPage(WebDriver driver) {
	super(driver);
    }

    public boolean hasPost(String postTitle) {
	return (isElementPresent(By.linkText(postTitle)));
    }

}
