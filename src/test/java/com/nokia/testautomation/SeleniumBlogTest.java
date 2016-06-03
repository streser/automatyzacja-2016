package com.nokia.testautomation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBlogTest extends SeleniumBase {

	private static final By NewPostButton = By.xpath("/html/body/div[2]/div/header/a[3]");
	private static final By XPathToTitleInputForm = By.xpath("//input[@class=\"editor-title__input form-text-input\"]");

	@Test
	public void AddNewPostAndVerify() throws Exception {

		String name = "kk_" + randomName();
		
		open("/");
		logIn("szkolenieautomatyzacja", "qw12qw12");
		String linkToNewPost = addNewPost(name);
		openLinkInNewWindow(linkToNewPost);
		
		assertNewPostIsAddedOnPage(name);

	}

	public void assertNewPostIsAddedOnPage(String name) {
		assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/main/article/div/header/h1")).getText(),
				name);
	}

	public void openLinkInNewWindow(String linkToNewPost) {
		driver.quit();
		driver = new FirefoxDriver();
		driver.get(linkToNewPost);
	}

	public String addNewPost(String name) {
		// click new post
		click(NewPostButton);

		// input title
		waitForElements(XPathToTitleInputForm);
		insertText(XPathToTitleInputForm, name);

		// click HTML textarea
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/ul/li[2]/a"));
		click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/ul/li[2]/a"));

		// input textarea text
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea"));
		insertText(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea"), "Tekst");

		// publish
		click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]"));

		// wait for green bar
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a"));

		return driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a"))
				.getAttribute("href");
	}
}
