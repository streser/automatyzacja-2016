package com.nokia.integrationtests;

import org.junit.Test;

import com.nokia.applicationmodel.AddNextPostPage;
import com.nokia.applicationmodel.GoToPosts;
import com.nokia.applicationmodel.GoToReadingPage;
import com.nokia.applicationmodel.ListOfPost;
import com.nokia.applicationmodel.LoginPage;
import com.nokia.applicationmodel.PostPage;

public class PostTest extends SeleniumTest{
	
	@Test
	public void postVerify() {
		LoginPage lp = new LoginPage(driver);
		lp.open();
		PostPage pp = lp.login("szkolenieautomatyzacja", "qw12qw12");

		
		AddNextPostPage anpp = pp.goToAddNextPost();
		String title = "Rafal"+randomName();
		
		//WHEN
		anpp.addNextPost(title);
		
		//THEN
		pp = anpp.goToPostsPage();
		pp.assertThatPostIs(title);
	}
	
	@Test
	public void postRemove() {
		LoginPage lp = new LoginPage(driver);
		lp.open();
		PostPage pp = lp.login("szkolenieautomatyzacja", "qw12qw12");
		String title = "Rafal"+randomName();
		//xpath    /html/body/div[2]/div/header/a[2]/span
		//class    masterbar__item-content
		GoToPosts gtp = pp.goToPosts();
		ListOfPost lop = gtp.findPost(title);
		
		//WHEN
		lop.removePost(title);
		
		//THEN
		
		pp.assertThatPostNot(title);
	}

}
