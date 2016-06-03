package com.nokia.testautomation.model;

import org.openqa.selenium.WebDriver;

public class BlogPage extends Page{

	private static final String ADD_POST_URL = "https://wordpress.com/post/automatyzacjacs.wordpress.com";
	
	public BlogPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void addPost() {
		openUrl(ADD_POST_URL);		
	}

}
