package com.nokia.applicationmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.nokia.integrationtests.GoToPosts;

public class PostPage extends MenuPage {
	
	private static final By LISTS_POSTS = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/ul/li[2]/ul/li[1]/a[1]/span");
	private static final By ADMIN_LINK = By.xpath("/html/body/div[2]/div/header/a[1]/span");
	private static final By BLOG_READING_LINK = By.xpath("/html/body/div[2]/div/header/a[2]/span");
	private static final String ACTIVITY_AVATAR_LINK = "//div[2]/div/header/a[3]";
	private static final String ARTICLE_LINK = "//div/article[1]/a";
	private String title;

	public PostPage(WebDriver driver) {
		super(driver);
	}

	public AddNextPostPage goToAddNextPost() {
		click(By.xpath(ACTIVITY_AVATAR_LINK));
		waitForElement(By.xpath("//div/input"));
		return new AddNextPostPage(driver);
	}

	public void assertThatPostIs(final String title) {

		driver.get("https://automatyzacjacs.wordpress.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {
			public boolean apply(WebDriver input) {
				return assertThatPostWasAdded(driver, title) != null;
			}
		});
		}
	
	private WebElement assertThatPostWasAdded(WebDriver driver, String title) {
		List<WebElement> elemnts = driver.findElements(By.tagName("a"));
		for (WebElement element : elemnts) {

			if (element.getAttribute("href").contains(title.toLowerCase())) {
				return element;
			}
		}
		return null;
	}

	public GoToReadingPage goToReadingPage() {
		click(BLOG_READING_LINK);
		waitForElement(By.xpath(ARTICLE_LINK));
		return new GoToReadingPage(driver);
	}

	public void findPost() {
		// 
		
		
	}

	public GoToPosts goToPosts() {
		click(ADMIN_LINK);
		waitForElement(LISTS_POSTS);
		click(LISTS_POSTS);
		///html/body/div[2]/div/div[2]/div[1]/main/div[2]/div/article[2]/div[2]/ul/li[4]/a/span
		return new GoToPosts(driver);
	}


		

}
