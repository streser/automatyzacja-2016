package com.nokia.unittests;

import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nokia.testautomation.model.BlogPage;
import com.nokia.testautomation.model.LoginPage;
import com.nokia.testautomation.model.PostAddPage;
import com.nokia.testautomation.model.PostListPage;
import com.nokia.testautomation.model.PostViewPage;

public class WordPressAddItemNewTest extends WordPressBase
{
	static String postTitle;
	
	@BeforeClass
	public static void beforeTestClass()
	{
		postTitle = "pawelg " + UUID.randomUUID().toString();		
	}
	
	@Before
	public void beforeTest()
	{
		init();		
	}
	
	@Test
	public void testAddPost() throws Exception
	{
		LoginPage loginP = new LoginPage(driver);
		loginP.open();
		
		loginP.login("szkolenieautomatyzacja", "qw12qw12");
		
		BlogPage blogP = new BlogPage(driver);
		blogP.addPost();
		
		PostAddPage postP = new PostAddPage(driver);
		
		postP.fillPost(postTitle);
		postP.submitPost();
		postP.goToPostViewPage();
		
		PostViewPage postViewP = new PostViewPage(driver);
		
		Assert.assertTrue(postViewP.isPostPresent(postTitle));		
		
		
		
		
	}
	
	@Test
	public void removeTest() throws Exception
	{
		LoginPage loginP = new LoginPage(driver);
		loginP.open();
		
		loginP.login("szkolenieautomatyzacja", "qw12qw12");
		
		BlogPage blogP = new BlogPage(driver);
		blogP.showPostsList();
		
		PostListPage postListP = new PostListPage(driver);
		
		postListP.findPost(postTitle);
		
		postListP.removePost(postTitle);
		
		Assert.assertTrue(postListP.isPostRemoved());
	}
	
	@After
	public void afterTest()
	{
		driver.quit();
	}
	

}
