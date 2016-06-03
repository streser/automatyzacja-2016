package com.nokia.unittests;

import java.util.UUID;

import org.junit.Test;
import org.openqa.selenium.By;

public class AddNewPostTest extends SeleniumBase {

	@Test
	public void shouldCreateNewPostAndVerifyCreation() throws Exception {
		openLogInForm();
		logIn("szkolenieautomatyzacja", "qw12qw12");

		String title = randomName();
		addPost(title);
		validatePostCreated(title);
		logOut();
	}
	
	

	@Override
	protected void logOut() {
		waitForElement(By.xpath("//div[6]/div/ul[2]/li[2]/a"));
		click(By.xpath("//div[6]/div/ul[2]/li[2]/a"));
		waitForElement(By.xpath("//div[6]/div/ul[2]/li[2]/div/ul/li[1]/div/form/button"));
		click(By.xpath("//div[6]/div/ul[2]/li[2]/div/ul/li[1]/div/form/button"));
	}



	public String randomName() {
		return UUID.randomUUID().toString() + " by Przemek K";
	}

}
