package com.nokia.integrationtests;

import org.junit.Test;

import com.nokia.applicationmodel.AddNextPostPage;
import com.nokia.applicationmodel.LoginPage;
import com.nokia.applicationmodel.PostPage;
import com.nokia.unittests.SeleniumBase;

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

}
