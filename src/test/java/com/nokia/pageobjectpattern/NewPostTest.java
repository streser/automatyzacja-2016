package com.nokia.pageobjectpattern;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.nokia.ravs.BlogPage;
import com.nokia.ravs.LoginPage;
import com.nokia.ravs.PostsPage;

public class NewPostTest extends SeleniumTest{
		String title = "MarekP" + UUID.randomUUID().toString();
	@Test
	public void shouldAddNewPost() throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		lp.open("https://pl.wordpress.com/");
		PostsPage pp = lp.login();
		pp.addNewPost(title);
		BlogPage bp = pp.goToBlog();
		Assert.assertTrue(bp.checkPostAdded(title));
	}	
}
