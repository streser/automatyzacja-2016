package com.nokia.application.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class PostsPage extends Page {

	public PostsPage(WebDriver driver) {
		super(driver);
	}

	public AddNewPostPage goToAddNewPost() {
		waitForElement(By.className("masterbar__item-new"));
		click(By.className("masterbar__item-new"));
		return new AddNewPostPage(driver);
	}

	private boolean checkPostName(final String postTitle) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new Predicate<WebDriver>() {
				public boolean apply(WebDriver input) {
					return assertThatPostWasAdded(driver, postTitle) != null;
				}
			});		
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	private WebElement assertThatPostWasAdded(WebDriver driver, String postTitle) {
		List<WebElement> elemnts = driver.findElements(By.tagName("a"));
		for (WebElement element : elemnts) {
			if (element.getAttribute("href").contains(postTitle)) {
				return element;
			}
		}
		return null;
	}

	public boolean assertThatPostIsPosted(String postTitle) {
		return checkPostName(postTitle);
	}

}
