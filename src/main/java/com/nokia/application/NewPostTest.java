package com.nokia.application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.nokia.unittests.seleniumSuperClass;

public class NewPostTest extends seleniumSuperClass {
	@Test
	public void shouldCreateNewPost() {
		final String INPUT_TEXT = "New Title";
		//given
		LoginPage lp = new LoginPage(driver);
		lp.open("https://pl.wordpress.com");		
		lp.logIn("szkolenieautomatyzacja", "qw12qw12");

		//when		
		PostPage pp = new PostPage(driver); 
		pp.addNewPost(INPUT_TEXT);
		BlogPage bp = pp.goBlogPage();		

		//then
		Assert.assertTrue(bp.hasPost(INPUT_TEXT));
	}
	
	@After
	public void tearDown(){
		driver.close();	
	}
	
}



// logowanie -> pierwsza strona po zalogowaniu -> dodaj nowy blog -> blog zostal dodany