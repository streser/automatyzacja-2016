package com.nokia.unittest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class WordpressPostTest extends SeleniumBase {

    private static final String BLOGURL = "automatyzacjacs.wordpress.com/";

    @Test
    public void testWordPressPost() throws Exception {
	wordpressLogin("szkolenieautomatyzacja", "qw12qw12");
	assertLoginSuccessfull();
	String postId = createPost(randomName(), "post contents");
	wordpressLogout();
	// verify logged out
	waitForElement(By.className("click-wpcom-login"));
	// go to automatyzacjacs.wordpress.com
	openUrl(BLOGURL);
	waitForElement(By.id("masthead"));
	assertTrue(isElementPresent(By.linkText(postId)));
    }

    private void assertLoginSuccessfull() throws InterruptedException {
	waitForElement(By.cssSelector("svg.gridicon.gridicons-user-circle"));
    }

    public String createPost(String pName, String pText) throws InterruptedException {
	waitForElement(By.className("masterbar__item-new"));
	click(By.className("masterbar__item-new")); // new post
	insertText(By.className("editor-title__input"), pName); // title text
	click(By.xpath("//span[@class='segmented-control__text'][text()='HTML']")); // switch to HTML editor
	insertText(By.id("tinymce-1"), pText); // insert contents
	waitForElement(By.className("editor-ground-control__publish-button"));
	click(By.className("editor-ground-control__publish-button")); // publish
	//waitForElement(By.className("notice__content"));
	return pName;
    }

}