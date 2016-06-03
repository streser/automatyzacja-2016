package com.nokia.pageobjectpattern;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.nokia.ravs.AllPostsPage;
import com.nokia.ravs.LoginPage;
import com.nokia.ravs.PostsPage;

public class DeletePostTest extends SeleniumTest {
	@Test

	public void shouldDeletePost() throws InterruptedException {
		String title = "MarekP" + UUID.randomUUID().toString();

		LoginPage lp = new LoginPage(driver);
		lp.open("https://pl.wordpress.com/");
		PostsPage pp = lp.login();
		pp.addNewPost(title);
		AllPostsPage ap = pp.goToAllPostsPage();
		ap.findPost(title);
		ap.removePost();
	}

}
