package com.nokia.testautomation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostListPage extends Page {

	private final String SEARCH_OPEN_SVG_XPATH = "/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]";
	private final String SEARCH_INPUT_XPATH = "/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]/input";
	private final String TRASH_A_XPATH = "/html/body/div[2]/div/div[2]/div[1]/main/div[2]/div/article[1]/div[2]/ul/li[4]/a/span";
	//private final String SUCC_REMOVE_TEXT_XPATH = "/html/body/div[2]/div/div[2]/div[1]/main/div[2]/div/article[1]/span/div/div/div/span";
	private final String SUCC_REMOVE_TEXT_XPATH = "//div[@class=\"conf-alert conf-alert--trashed\"]";
	
	public PostListPage(WebDriver driver) {
		super(driver);
		
	}

	public void findPost(String postTitle) throws Exception
	{
		WebElement svgOpenSearchElem = findElementByXpath(SEARCH_OPEN_SVG_XPATH);
		svgOpenSearchElem.click();
		WebElement inputSearchElem = findElementByXpath(SEARCH_INPUT_XPATH);
		insertText(inputSearchElem, postTitle);
		
	}

	public void removePost(String postTitle) throws Exception
	{
		WebElement postElement = findElementByLinkText(postTitle);
		WebElement trashElement = findElementByXpath(TRASH_A_XPATH);
		trashElement.click();		
	}

	public boolean isPostRemoved() throws Exception {
		WebElement trashPopup = findElementByXpath(SUCC_REMOVE_TEXT_XPATH);
		return trashPopup != null;
	}
	
	

}
