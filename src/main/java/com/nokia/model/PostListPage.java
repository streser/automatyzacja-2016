package com.nokia.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostListPage extends Page {
	
	private static final String ADD_NEW_POST = "//div[2]/div/header/a[3]";
	private static final String PUBLISH = "//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]";
	private static final String COMMENT_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea";
	private static final String TITLE_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input";

	public PostListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void createPost(String title, String comment) throws InterruptedException {
		clickAddPost();
		addTextToPost(title, comment);
	}
	
	private void clickAddPost() throws InterruptedException {
		click(By.xpath(ADD_NEW_POST));
		waitForElement(TITLE_FIELD);
	}
	
	private void addTextToPost(String title, String comment) throws InterruptedException {
		insertTextByXPath("", TITLE_FIELD);
		insertTextByXPath(comment, COMMENT_FIELD);
		insertTextByXPath(title, TITLE_FIELD);
		click(By.xpath(PUBLISH));
		waitForElementByLinkText("automatyzacjacs");
	}

	public BlogPage goToBlog() {
		return new BlogPage(driver);
	}

}
