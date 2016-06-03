package com.nokia.testautomation.integrationtestPageObjPattern;

import org.junit.Test;

public class NewPostTest extends TestScenario {

	@Test
	public void shouldBePossibleToAddPost() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		String name = "kk_" + lp.randomName();
		lp.open("/");
		PostPage pp = lp.login("szkolenieautomatyzacja", "qw12qw12");
		AddNewPostPage anpp = pp.goToAddNewPage();
		
		String link = anpp.addNewPost(name, "Tekst");

		PostPage newpp = anpp.goToPostPage(link);
		newpp.assertThatPostIsPresent(name);
	}
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

}
