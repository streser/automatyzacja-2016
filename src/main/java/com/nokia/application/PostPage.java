package com.nokia.application;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends PageObjectPattern {
	
	private static final By NewPostButton = By.xpath("/html/body/div[2]/div/header/a[3]");
	
	public PostPage(WebDriver driver) {
		super(driver);
	}

	public AddNewPostPage goToAddNewPage() {
		click(NewPostButton);
		return new AddNewPostPage(driver);
	}

	public void assertThatPostIsPresent(String name) {
		assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/main/article/div/header/h1")).getText(),
				name);
		driver.quit();
	}
	public void assertThatContentOfPostIsCorrect(String content) {
		assertEquals(driver.findElement(By.xpath("//div/div/p")).getText(),
				content);
		driver.quit();
	}

}

