package com.nokia.applicationmodel;

import org.openqa.selenium.WebDriver;

public class GoToPosts extends MenuPage {

	public GoToPosts(WebDriver driver) {
		super(driver);
	}

	public ListOfPost findPost(String title) {
		// /html/body/div[2]/div/div[2]/div[1]/main/div[2]/div/article[2]/div[2]/ul/li[4]/a/span
		return new ListOfPost();
		
	}

}
