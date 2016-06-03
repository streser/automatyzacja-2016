package com.nokia.testautomation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	public void open() {
		openUrl("https://pl.wordpress.com");		
	}

	public void login(String userName, String password) throws Exception {
		WebElement loginElement =  findElementByLinkText("Zaloguj się");
	    loginElement.click();
	
	    WebElement userLogin =getWebElementById("user_login");
	    
	    insertText(userLogin,userName);
	     
	    WebElement userPass = getWebElementById("user_pass");
	    insertText(userPass,password);
	    
	    WebElement submitElement = findElementById("wp-submit");
	    submitElement.click();
		
	}

}
