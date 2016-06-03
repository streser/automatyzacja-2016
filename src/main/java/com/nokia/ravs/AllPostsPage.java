package com.nokia.ravs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllPostsPage extends Page{

	private static final String DELETION_CONFIRMATION_BOX = "/html/body/div[2]/div/div[2]/div[1]/main/div[2]/div/div[2]/article/span/div/div/div";
	private static final String FIND_POST_TEXT_BOX = "/html/body/div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]/input";
	private static final String DELETE_POST_BUTTON = "//div[2]/div/div[2]/div[1]/main/div[2]/div[1]/article/div[2]/ul/li[4]/a";
	private static final String FIND_POST_BOX = "//div[2]/div/div[2]/div[1]/main/div[1]/div[2]/div[2]";

	public AllPostsPage(WebDriver driver) {
		super(driver);
	}

	public Object findPost(String title) {
		click(By.xpath(FIND_POST_BOX));
		insertTextByXpath(title, FIND_POST_TEXT_BOX);
		return null;
	}

	public void removePost() throws InterruptedException {
		click(By.xpath(DELETE_POST_BUTTON));
	}

}
