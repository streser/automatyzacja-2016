package com.nokia.application.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostsList extends Page{

	private static final String SEARCH_INPUT_BOX_XPATH = "/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]/input";
	private static final By SEARCH_BUTTON = By.xpath("/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]");
	private static final By FIRST_REMOVE_BUTTON = By.xpath("/html/body/div[2]/div/div[2]/div[1]/main/div[2]/div/article[1]/div[2]/ul/li[4]/a/span");

	public PostsList(WebDriver driver) {
		super(driver);
	}

	public void removePost(String title) {
		waitForElement(SEARCH_BUTTON);
		click(SEARCH_BUTTON);
		insertTextByXpath(SEARCH_INPUT_BOX_XPATH, title);
		waitForElement(FIRST_REMOVE_BUTTON);
		click(FIRST_REMOVE_BUTTON);
	}

	public void goToTrashedPostsList(String title) {
		// TODO Auto-generated method stub
		
	}

	public void assertThatPostRemoved(String title) {
		// TODO Auto-generated method stub
		
	}

}
