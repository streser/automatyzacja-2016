package com.nokia.application.model;

import org.openqa.selenium.WebDriver;

public class PostsPage extends Page{

	public PostsPage(WebDriver driver) {
		super(driver);
	}

	public BlogPage goToBlog() {
		open("/post/automatyzacjacs.wordpress.com");
		return new BlogPage(driver);
	}

}
