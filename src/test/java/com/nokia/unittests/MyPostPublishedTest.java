package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyPostPublishedTest extends SeleniumBase {

	private String randomString;

	@Test
	public void isMyPostPublished() throws Exception {
		openLogInForm();

		logIn("szkolenieautomatyzacja", "qw12qw12");

		open("/post/automatyzacjacs.wordpress.com");

		waitForElement(By.className("form-text-input"));

		randomString = randomName().toLowerCase();

		insertText(By.className("form-text-input"), "Anna-" + randomString);
		click(By.className("editor-ground-control__publish-button"));

		waitForElement(By.className("post-editor__notice"));
		driver.get("https://automatyzacjacs.wordpress.com");

		assertThatPostWasPublishedSuccessfully();

	}

	private void assertThatPostWasPublishedSuccessfully() {
		Assert.assertTrue(
				driver.findElement(By.className("cover-link")).getAttribute("href").contains("anna-" + randomString));
	}
}
