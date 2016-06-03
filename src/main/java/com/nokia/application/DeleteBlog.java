package com.nokia.application;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DeleteBlog extends PageObjectPattern {

	public DeleteBlog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final By NewPostButton = By.xpath("/html/body/div[2]/div/header/a[3]");

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
/*
/html/body/div[5]/ul/li[2]/a/span

/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/button[3]
		
/html/body/div[11]/div/div/div/div[2]/button[2]
*/
