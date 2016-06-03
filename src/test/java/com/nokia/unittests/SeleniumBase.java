package com.nokia.unittests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {

	protected WebDriver driver;
	protected StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	protected void logIn(String userName, String password)
			throws InterruptedException {
		
				openUrl("https://pl.wordpress.com");
				WebElement loginElement =  findElementByLinkText("Zaloguj się");
			    loginElement.click();
			
			    WebElement userLogin =getWebElementById("user_login");
			    
			    insertText(userLogin,userName);
			     
			    WebElement userPass = getWebElementById("user_pass");
			    insertText(userPass,password);
			    
			    WebElement submitElement = findElementById("wp-submit");
			    submitElement.click();
			}

	protected void insertText(WebElement element, String text) {
		  element.clear();
		  element.sendKeys(text);  
	  }

	protected WebElement getWebElementByLinkText(String linkText) {
		  return driver.findElement(By.linkText(linkText));
	  }

	protected WebElement getWebElementByXPath(String linkText) {
		  return driver.findElement(By.linkText(linkText));
	  }

	protected WebElement getWebElementById(String id) {
		  return driver.findElement(By.id(id));
	  }
	
	protected WebElement getWebElementByCss(String selector) {
		  return driver.findElement(By.cssSelector(selector));
	  }

	protected WebElement findElementByLinkText(String linkText)
			throws InterruptedException {
				for (int second = 0;; second++) {
			    	if (second >= 60) fail("timeout");
			    	try 
			    	{ 
			    		WebElement element = isElementPresent(By.linkText(linkText));
			    		if (element != null) return element; 
			    	} catch (Exception e) {}
			    	Thread.sleep(1000);
			    }
			}

	protected WebElement findElementById(String id) throws InterruptedException {
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try 
	    	{ 
	    		WebElement element = isElementPresent(By.id(id));
	    		if (element != null) return element; 
	    	} catch (Exception e) {}
	    	Thread.sleep(1000);
	    }		
	}
	
	protected WebElement findElementByXpath(String xpath) throws InterruptedException {
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try 
	    	{ 
	    		WebElement element = isElementPresent(By.xpath(xpath));
	    		if (element != null) return element; 
	    	} catch (Exception e) {}
	    	Thread.sleep(1000);
	    }		
	}

	protected WebElement isElementPresent(By by) {
	    try {
	      WebElement element = driver.findElement(by);
	      return element;
	    } catch (NoSuchElementException e) {
	      return null;
	    }
	  }
	
	protected void openUrl(String url)
	{
		driver.get(url);
	}
	

	protected void logOut() throws InterruptedException {
		WebElement logOutElem = getWebElementByCss("img.gravatar");
		logOutElem.click();
		WebElement buttonLogOtuElem = findElementByXpath("(//button[@type='submit'])[2]");
		buttonLogOtuElem.click();
	}
}