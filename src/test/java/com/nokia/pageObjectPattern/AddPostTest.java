package com.nokia.pageObjectPattern;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.nokia.model.BlogPage;
import com.nokia.model.LoginPage;
import com.nokia.model.PostListPage;

public class AddPostTest extends SeleniumContext {
	String title = "Slawek_"+UUID.randomUUID().toString();
	String comment = UUID.randomUUID().toString() + UUID.randomUUID().toString();
	
	@Test
	public void shouldBePossibleToAddPost() throws InterruptedException {
		LoginPage lp = new LoginPage(driver, baseUrl);
		PostListPage pl = lp.login("szkolenieautomatyzacja", "qw12qw12");
		pl.createPost(title, comment);
		BlogPage bp = pl.goToBlog();
		Assert.assertTrue(bp.hasPost(title));
	}
}
