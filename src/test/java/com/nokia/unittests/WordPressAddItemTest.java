package com.nokia.unittests;

import java.util.UUID;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.WebElement;

public class WordPressAddItemTest extends SeleniumBase {
	
	@Test
	public void testAdd() throws Exception
	{
		logIn("szkolenieautomatyzacja", "qw12qw12");
		String content = "content text";
		
		openUrl("https://wordpress.com/post/automatyzacjacs.wordpress.com");
		WebElement titleElement = waitForElementByXpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		
		String uuid = UUID.randomUUID().toString();
		String uniqueTilteText = "pawelg " + uuid;
		
		insertText(titleElement, uniqueTilteText);
		
		WebElement contentElement = waitForElementByXpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea");
		
		insertText(contentElement,content);
		
		WebElement publishButton = waitForElementByXpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]");
		
		insertText(titleElement, uniqueTilteText);
		
				
		publishButton.click();
		
		WebElement postAddDone = waitForElementByLinkText("Zobacz wpis");
														   //html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/span/a
		//postAddDone.click();
		//Thread.sleep(10000);
		System.out.println("opening url");
		openUrl("https://automatyzacjacs.wordpress.com");
		System.out.println("url opened");
		
		WebElement postElementTitle = waitForElementByLinkText(uniqueTilteText);		
		
		Assert.assertTrue(postElementTitle != null);
		
		//WebElement postElementContent = waitForElementByLinkText(content);		
		
		//Assert.assertTrue(postElementContent != null);
		
		
	}

}
