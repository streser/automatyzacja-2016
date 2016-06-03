package com.nokia.testautomation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostAddPage extends Page{

	private static final String POST_TITLE_ELEMENT_XPATH = "//input[@class=\"editor-title__input form-text-input\"]";
	private static final String POST_PUBLISH_BUTTON_XPATH = "//button[@class=\"editor-ground-control__publish-button button is-primary\"]";
	private static final String SHOW_NEW_POST_TEXT = "Zobacz wpis";
	
	public PostAddPage(WebDriver driver) {
		super(driver);
		
	}

	public void fillPost(String postTitle) throws Exception {
		WebElement titleElement = findElementByXpath(POST_TITLE_ELEMENT_XPATH);
		insertText(titleElement, postTitle);		
	}

	public void submitPost() throws Exception {
		WebElement publishButton = findElementByXpath(POST_PUBLISH_BUTTON_XPATH);
		publishButton.click();
		
	}
	
	public void goToPostViewPage() throws Exception {
		WebElement showPostButton = findElementByLinkText(SHOW_NEW_POST_TEXT);
		openUrl(showPostButton.getAttribute("href"));
	}

}
