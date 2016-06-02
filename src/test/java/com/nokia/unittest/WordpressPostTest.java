package com.nokia.unittest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class WordpressPostTest extends SeleniumBase {

    @Test
    public void testWordPressPost() throws Exception {
	wordpressLogin("szkolenieautomatyzacja", "qw12qw12");
	assertLoginSuccessfull();
	
	//
	String postId = createPost();
	
	wordpressLogout();
	// verify logged out
	waitForElement(By.className("click-wpcom-login"));
	
	// go to automatyzacjacs.wordpress.com
	// 
	openBlog();
	waitForElement(By.id("masthead"));
	assertTrue(isElementPresent(By.linkText(postId)));
	
    }

    private void assertLoginSuccessfull() throws InterruptedException {
	waitForElement(By.cssSelector("svg.gridicon.gridicons-user-circle"));
	assertTrue(isElementPresent(By.cssSelector("svg.gridicon.gridicons-user-circle")));
    }

}