package com.nokia.unittests;

import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nokia.testautomation.model.BlogPage;
import com.nokia.testautomation.model.LoginPage;
import com.nokia.testautomation.model.PostAddPage;
import com.nokia.testautomation.model.PostViewPage;

public class WordPressAddItemNewTest 
{
	WebDriver driver;
	String postTitle;
	
	@Before
	public void beforeTest()
	{
		driver = new FirefoxDriver();	
		postTitle = "pawelg " + UUID.randomUUID().toString();		
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
		
		PostViewPage postViewP = new PostViewPage(driver);
		
		Assert.assertTrue(postViewP.isPostPresent(postTitle));		
		
		
	}
	
	@After
	public void afterTest()
	{
		driver.quit();
	}
	

}
