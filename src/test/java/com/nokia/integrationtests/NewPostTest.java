package com.nokia.integrationtests;

import org.junit.Test;

import com.nokia.application.model.AddNewPostPage;
import com.nokia.application.model.BlogPage;
import com.nokia.application.model.LoginPage;
import com.nokia.application.model.PostsPage;

public class NewPostTest extends Scenario {
	String postTitle = "adamp-" + randomName();
	
	@Test
	public void shouldPostIsAdded() throws InterruptedException {
		// GIVEN
		LoginPage lp = new LoginPage(driver);
		lp.open();
		PostsPage pp = lp.logIn("szkolenieautomatyzacja", "qw12qw12");
		AddNewPostPage anpp = pp.goToAddNewPost();
		// WHEN
		anpp.addNewPost(postTitle);
		// THEN
		
		BlogPage bp = anpp.getToBlog();
		bp.assertThatPostIsPosted(postTitle);
	}
}
