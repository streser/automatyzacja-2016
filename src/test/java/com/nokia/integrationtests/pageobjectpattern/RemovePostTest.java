package com.nokia.integrationtests.pageobjectpattern;

import java.util.UUID;

import org.junit.Test;

import com.nokia.application.model.LoginPage;
import com.nokia.application.model.NewPostPage;
import com.nokia.application.model.PostsList;
import com.nokia.application.model.PostsPage;

public class RemovePostTest extends TestScenario {

	@Test
	public void shouldCreateNewPost() {
		String title = randomName();
		LoginPage lp = new LoginPage(driver);
		PostsPage pp = lp.logIn("szkolenieautomatyzacja", "qw12qw12");
		
		NewPostPage npp = pp.addNewPost(title);
		PostsList pl = npp.goToPostsList();
		pl.removePost(title);

		//TODO Go to Trashed Posts list and assert if post present on this page, then log out
//		pl.goToTrashedPostsList(title);
//		pl.assertThatPostRemoved(title);
//		pp.logOut();
	}

	public String randomName() {
		return UUID.randomUUID().toString() + " by Przemek K";
	}

}
