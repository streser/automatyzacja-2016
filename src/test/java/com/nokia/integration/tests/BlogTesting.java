package com.nokia.integration.tests;

import org.junit.Test;

import com.nokia.application.AddNewPostPage;
import com.nokia.application.LoginPage;
import com.nokia.application.PostPage;

public class BlogTesting extends TestCasesEnv {
	@Test
	public void shouldBePossibleToAddPost() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		String blogName = "Post by edmundb. ID: " + lp.randomName();
		String blogText = "Blog tests added by edmundb. ID: " + lp.randomName();
		lp.open("/");
		PostPage pp = lp.login("szkolenieautomatyzacja", "qw12qw12");
		AddNewPostPage anpp = pp.goToAddNewPage();

		String link = anpp.addNewPost(blogName, blogText);

		PostPage newpp = anpp.goToPostPage(link);
		newpp.assertThatPostIsPresent(blogName);
	}
/*
	@Test
	public void ContentOfPostShouldBeCorrect() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		String name = "kk_" + lp.randomName();
		String content = "Tekst";
		lp.open("/");
		PostPage pp = lp.login("szkolenieautomatyzacja", "qw12qw12");
		AddNewPostPage anpp = pp.goToAddNewPage();

		String link = anpp.addNewPost(name, content);

		PostPage newpp = anpp.goToPostPage(link);
		newpp.assertThatContentOfPostIsCorrect(content);
	}
*/
}
