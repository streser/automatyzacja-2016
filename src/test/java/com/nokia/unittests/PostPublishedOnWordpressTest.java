package com.nokia.unittests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class PostPublishedOnWordpressTest extends SeleniumBase {

	private static final String ANNA = "anna-";
	private static final String POST_TITLE_INPUT = "form-text-input";

	@Test
	public void isPostPublishedOnWordpress() throws Exception {
		openLogInForm();

		logIn("szkolenieautomatyzacja", "qw12qw12");

		open("/post/automatyzacjacs.wordpress.com");

		String postTitle = ANNA + randomName().toLowerCase();

		publishPost(postTitle);

		assertThatPostWasPublishedOnWordpressSuccessfully(postTitle);

	}

	private void publishPost(String postTitle) {
		waitForElement(By.className(POST_TITLE_INPUT));
		insertText(By.className(POST_TITLE_INPUT), postTitle);
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.className("post-editor__notice"));
	}

	private void assertThatPostWasPublishedOnWordpressSuccessfully(String postTitle) {
		openPage("https://automatyzacjacs.wordpress.com");
		Assert.assertTrue(driver.findElement(By.className("cover-link")).getAttribute("href").contains(postTitle));
	}
}