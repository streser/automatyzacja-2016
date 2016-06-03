package com.nokia.testautomation.integrationtestPageObjPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewPostPage extends Page {
	WebDriver driver;

	public AddNewPostPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private static final By XPathToTitleInputForm = By.xpath("//input[@class=\"editor-title__input form-text-input\"]");

	public String addNewPost(String title, String content) {
		// input title
		waitForElements(XPathToTitleInputForm);
		insertText(XPathToTitleInputForm, title);

		// click HTML textarea
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/ul/li[2]/a"));
		click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/ul/li[2]/a"));

		// input textarea text
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea"));
		insertText(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea"), content);

		// publish
		click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]"));

		// wait for green bar
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a"));
		
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a"))
				.getAttribute("href");
	}

	public PostPage goToPostPage(String link) {
		driver.quit();
		driver = new FirefoxDriver();
		driver.get(link);
		
		return new PostPage(driver);
	}

}
