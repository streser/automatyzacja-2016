package com.nokia.unittests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class seleniumPublishPost extends seleniumSuperClass {
	final String INPUT_TEXT = "justtesting";
	final String NEW_POST_URL = "https://automatyzacjacs.wordpress.com";

	private void addNewPost(String string) {
		click(By.className("masterbar__item-new"));
		insertText(By.className("form-text-input"), string);
	}

	private void assertThatNewPostIsAdded(final String text, String text2) {
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.className("notice__action"));
		openWebPage(NEW_POST_URL);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {

			public boolean apply(WebDriver arg0) {
				return driver.getPageSource().contains(text);
			}
		});
		driver.close();
	}

	@Test
	public void shouldPublishPost() throws Exception {
		openWebPage(baseUrl);
		logIn("szkolenieautomatyzacja", "qw12qw12");
		addNewPost(INPUT_TEXT);
		assertThatNewPostIsAdded(NEW_POST_URL, INPUT_TEXT);
	}
}
