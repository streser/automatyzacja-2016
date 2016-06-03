package com.nokia.unittests;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class WordPressAddItemTest extends SeleniumBase {
	
	private static final String SHOW_NEW_POST_TEXT = "Zobacz wpis";

	private String uniqueTitleText;
	
	private static final String ADD_POST_URL = "https://wordpress.com/post/automatyzacjacs.wordpress.com";
	private static final String POST_TITLE_ELEMENT_XPATH = "//input[@class=\"editor-title__input form-text-input\"]";
	private static final String POST_PUBLISH_BUTTON_XPATH = "//button[@class=\"editor-ground-control__publish-button button is-primary\"]";
	
	@Before
	public void beforeTest()
	{
		uniqueTitleText = "pawelg " + UUID.randomUUID().toString();;
	}
	
	@Test
	public void testAdd() throws Exception
	{
		logIn("szkolenieautomatyzacja", "qw12qw12");
		addPostAndCheck();		
				
	}

	private void addPostAndCheck() throws InterruptedException {
		
		openUrl(ADD_POST_URL);
				
		WebElement titleElement = waitForElementByXpath(POST_TITLE_ELEMENT_XPATH);
		insertText(titleElement, uniqueTitleText);
		
		WebElement publishButton = waitForElementByXpath(POST_PUBLISH_BUTTON_XPATH);
		publishButton.click();
		
		WebElement showPostButton = waitForElementByLinkText(SHOW_NEW_POST_TEXT);
		openUrl(showPostButton.getAttribute("href"));
				
		WebElement postTitleCheckElement = waitForElementByLinkText(uniqueTitleText);		
		Assert.assertTrue(postTitleCheckElement != null);
	}

}
