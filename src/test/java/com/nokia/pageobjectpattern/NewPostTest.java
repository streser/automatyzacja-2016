package com.nokia.pageobjectpattern;

import org.junit.Assert;
import org.junit.Test;

import com.nokia.application.model.BlogPage;
import com.nokia.application.model.LoginPage;
import com.nokia.application.model.PostsPage;

public class NewPostTest extends TestScenario {

	private static final String ANNA = "anna-";
	public String postTitle;
	
	@Test
	public void isPostPublished() {
		LoginPage lp = new LoginPage(driver);
		lp.openLoginPage();
		
		PostsPage pp = lp.logIn();
		
		BlogPage bp = pp.goToBlog();
		
		postTitle = ANNA + randomName().toLowerCase();
		
		bp.create(postTitle);
		
		bp.goToPostPage();
		
		Assert.assertTrue(bp.hasPost(postTitle));
		
	}
}
