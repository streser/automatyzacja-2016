package com.nokia.pageObjectPattern;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.nokia.model.AllPostsPage;
import com.nokia.model.LoginPage;
import com.nokia.model.PostListPage;

public class DeletePost extends SeleniumContext{
	String title = "Slawek_"+UUID.randomUUID().toString();
	String comment = UUID.randomUUID().toString() + UUID.randomUUID().toString();

	@Test
	public void shouldDeleteCretedPost() throws InterruptedException {
		LoginPage lp = new LoginPage(driver, baseUrl);
		PostListPage pl = lp.login("szkolenieautomatyzacja", "qw12qw12");
		pl.createPost(title, comment);
		
		AllPostsPage app = new AllPostsPage(driver);
		app.findPost(title, true);
		app.deletePost(title);
		app.findPost(title, false);
		Assert.assertTrue(app.isDeletionSuccessful(title));
		lp.logOut();
	}
}
