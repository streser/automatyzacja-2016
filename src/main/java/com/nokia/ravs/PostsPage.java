package com.nokia.ravs;


import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PostsPage extends Page{
	private static final String POSTS_ON_BLOG = "/html/body/div[2]/div/div[2]/div[2]/div/ul/li[2]/ul/li[1]/a[1]/span";
	private static final String MY_PAGE_BUTTON = "/html/body/div[2]/div/header/a[1]/span";

	public PostsPage(WebDriver driver) {
		super(driver);
	}
	private static final String POST_ADDED_MSG = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/span/a";
	private static final String ADD_POST_BUTTON = "/html/body/div[2]/div/header/a[3]";
	private static final String PUBLISH_POST_BUTTON = "//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]";
	private static final String TITLE_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input";

	public boolean addNewPost(String post_title) throws InterruptedException {
		AddPost(post_title);
		return false;
	}
	
	public String randomName() {
		return UUID.randomUUID().toString();
	}
	private void AddPost(String title) throws InterruptedException {
		click(By.xpath(ADD_POST_BUTTON));
		waitForElementXPath(TITLE_FIELD);
		insertTextByXpath(title, TITLE_FIELD);
		click(By.xpath(PUBLISH_POST_BUTTON));
		waitForElementXPath(POST_ADDED_MSG);

	}

	public BlogPage goToBlog() {
		return new BlogPage(driver);
	}

	public AllPostsPage goToAllPostsPage() {
		click(By.xpath(MY_PAGE_BUTTON));
		click(By.xpath(POSTS_ON_BLOG));
		return new AllPostsPage(driver);
	}
}
