package com.nokia.application.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostListPage extends Page {
//    private static final String POST_LIST_URL = "https://wordpress.com/posts/automatyzacjacs.wordpress.com";

    public PostListPage(WebDriver driver) throws InterruptedException {
	super(driver);
	click(By.className("masterbar__item-content"));
	acceptAlertIfPresent();
	waitForElement(By.xpath("//*[@id='secondary']/div/ul/li[2]/ul/li[1]/a[1]"));
	click(By.xpath("//*[@id='secondary']/div/ul/li[2]/ul/li[1]/a[1]"));
    }

    // search button on post list class="search-open__icon"
    // search input class="search__input"
    public void deletePost(String postTitle) throws InterruptedException {
	waitForElement(By.className("search-open__icon"));
	click(By.className("search-open__icon"));
	waitForElement(By.className("search__input"));
	insertText(By.className("search__input"), postTitle);
	List<WebElement> found = driver.findElements(By.xpath("//article"));
	WebElement myPostElement = null;
	for (WebElement webElement : found) {
	    if (webElement.getText().contains(postTitle))
		myPostElement = webElement;
	}
	myPostElement.findElement(By.className("post-controls__trash")).click();
	// class = "post-controls__trash"
    }

}
