package com.nokia.testautomation.model;

import org.openqa.selenium.WebDriver;

public class BlogPage extends Page{

	private static final String ADD_POST_URL = "https://wordpress.com/post/automatyzacjacs.wordpress.com";
	private static final String LIST_POSTS_URL = "https://wordpress.com/posts/automatyzacjacs.wordpress.com";
	
	public BlogPage(WebDriver driver) {
		super(driver);
		
	}

	public void addPost() {
		openUrl(ADD_POST_URL);		
	}

	public void showPostsList() {
		openUrl(LIST_POSTS_URL);
		
	}

}
