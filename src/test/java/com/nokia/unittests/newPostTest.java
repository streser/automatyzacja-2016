package com.nokia.unittests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class newPostTest extends SeleniumBase {

	private static final String ACTIVITY_AVATAR_LINK = "//div[2]/div/header/a[3]";
	private static final String ARTICLE_LINK = "//div/article[1]/a";
	private String title;

	@Test
	public void TestPost() throws Exception {

		logIn("szkolenieautomatyzacja", "qw12qw12");// GIVEN

		title = "Rafal_" + randomName();// WHEN
		insertPost(title);

		checkPostName(title); // THEN

	}

	private void checkPostName(final String checkedTitle) {
		driver.get("https://automatyzacjacs.wordpress.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {
			public boolean apply(WebDriver input) {
				return assertThatPostWasAdded(driver, checkedTitle) != null;
			}
		});
	}

	private void insertPost(String title) {
		click(By.xpath(ACTIVITY_AVATAR_LINK));
		waitForElement(By.xpath("//div/input"));
		click(By.className("editor-ground-control__publish-button"));
		insertText(title, By.className("form-text-input"));
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.linkText("automatyzacjacs"));
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

	private void assertThatPostSuccessful() {
		assertEquals(title, driver.findElement(By.xpath(ARTICLE_LINK)).getAttribute("title"));
	}

	public void opennew(String path) {

		driver.get(path);
	}
}
