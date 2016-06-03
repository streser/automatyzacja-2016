package com.nokia.integrationtests;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import com.nokia.application.model.BlogPage;
import com.nokia.application.model.LoginPage;
import com.nokia.application.model.PostListPage;
import com.nokia.application.model.PostPage;

public class CreateDeletePostTest extends TestScrenario {

    private static final String POST_TEXT = UUID.randomUUID().toString();
    private static final String POST_TITLE = "witw " + POST_TEXT;

    public CreateDeletePostTest() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Test
    public void shouldCreateDeletePost() throws InterruptedException {
	LoginPage lp = new LoginPage(driver);
	PostPage pp = lp.logIn();
	pp.create(POST_TITLE, POST_TEXT);
	PostListPage pl = new PostListPage(driver);
	pl.deletePost(POST_TITLE);
    }
}
