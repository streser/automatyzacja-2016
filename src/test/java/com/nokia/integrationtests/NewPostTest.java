package com.nokia.integrationtests;

import org.junit.Assert;
import org.junit.Test;
import com.nokia.application.model.BlogPage;
import com.nokia.application.model.LoginPage;
import com.nokia.application.model.PostPage;



public class NewPostTest extends TestScrenario {

    private static final String POST_TEXT = "Post text";
    private static final String POST_TITLE = "Post Title";

    public NewPostTest() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Test
    public void shouldCreateNewPost() throws InterruptedException {
	LoginPage lp = new LoginPage(driver);
	PostPage pp = lp.logIn();
	pp.create(POST_TITLE, POST_TEXT);
	pp.logOut();
	BlogPage bp = pp.goToBlog();
	Assert.assertTrue(bp.hasPost(POST_TITLE));
    }
}
