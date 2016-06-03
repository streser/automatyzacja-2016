package com.nokia.application.model;

import org.openqa.selenium.WebDriver;

public class PostListPage extends Page {
    private static final String POST_LIST_URL = "https://wordpress.com/posts/automatyzacjacs.wordpress.com";

    public PostListPage(WebDriver driver) {
	super(driver);
	openUrl(POST_LIST_URL);
    }

    // search button on post list class="search-open__icon"
    // search input class="search__input"
    public void deletePost(String postTitle) {
	// class = "post-controls__trash"
	// TODO Auto-generated method stub
	
    }

}
