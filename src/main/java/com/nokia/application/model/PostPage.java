package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends Page {

    private static final String BLOG_URL = "automatyzacjacs.wordpress.com/";

    public PostPage(WebDriver driver) {
	super(driver);
    }

    public String create(String pName, String pText) throws InterruptedException {
	waitForElement(By.className("masterbar__item-new"));
	click(By.className("masterbar__item-new")); // new post
	insertText(By.className("editor-title__input"), pName); // title text
	click(By.xpath("//span[@class='segmented-control__text'][text()='HTML']")); // switch to HTML editor
	insertText(By.id("tinymce-1"), pText); // insert contents
	waitForElement(By.className("editor-ground-control__publish-button"));
	click(By.className("editor-ground-control__publish-button")); // publish
	// waitForElement(By.className("notice__content"));
	return pName;
    }

    public BlogPage goToBlog() throws InterruptedException {
	openUrl(BLOG_URL);
	waitForElement(By.id("masthead"));
	return new BlogPage(driver);
    }

}
