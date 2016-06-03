package com.nokia.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllPostsPage extends Page {

	private static final String TRASH_ICON = "//div[2]/div/div[2]/div[1]/main/div[2]/div[1]/article[1]/div[1]/footer/p/span/span[2]/svg/g/path";
	//private static final String TRASH_BUTTON = "//div[2]/div/div[2]/div[1]/main/div[2]/div/article[1]/div[2]/ul/li[4]/a";
	private static final String TRASH_BUTTON = "//div[2]/div/div[2]/div[1]/main/div[2]/div[1]/article/div[2]/ul/li[4]/a";
	private static final String LINK_AFTER_DELETE = "Cofnąć?";
	private static final String SEARCH_BUTTON = "/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]";
	private static final String SEARCH_INPUT = "/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]/input";

	public AllPostsPage(WebDriver driver) {
		super(driver);
	}

	public void findPost(String title,boolean wait) throws InterruptedException {
		open("https://wordpress.com/posts/automatyzacjacs.wordpress.com/");
		waitForElement(SEARCH_BUTTON);
		click(By.xpath(SEARCH_BUTTON));
		insertTextByXPath(title, SEARCH_INPUT);
		if (wait) {
			waitForElementByLinkText(title);
		}
	}

	public void deletePost(String title) throws InterruptedException {
		//click(By.className("post-controls__trash"));
		waitForElement(TRASH_BUTTON);
		//waitForElementByClass("post-controls__trash");
		//click(By.className("post-controls__trash"));
		//waitForElement(TRASH_ICON);
		click(By.xpath(TRASH_BUTTON));
		waitForElementByLinkText(LINK_AFTER_DELETE);
	}

	public boolean isDeletionSuccessful(String title) {
		//return isElementPresent(By.xpath("//div[2]/div/div[2]/div[1]/main/div[2]/div/div/img"));
		return isElementPresent(By.linkText(LINK_AFTER_DELETE));
	}

}
