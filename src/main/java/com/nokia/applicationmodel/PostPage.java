package com.nokia.applicationmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class PostPage extends MenuPage {
	
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
		

}
