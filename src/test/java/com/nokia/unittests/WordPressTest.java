package com.nokia.unittests;


import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WordPressTest {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAutomation() throws Exception {
    driver.get("https://pl.wordpress.com");
    logIn("szkolenieautomatyzacja", "qw12qw12");
    
    checkLoginSuccessful();
  }

private void checkLoginSuccessful() {
	assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")) != null);
}

private void logIn(String userName, String password) throws InterruptedException {
	WebElement loginElement =  waitForElementByLinkText("Zaloguj się");
    loginElement.click();

    WebElement userLogin =getWebElementById("user_login");
    
    insertText(userLogin,userName);
     
    WebElement userPass = getWebElementById("user_pass");
    insertText(userPass,password);
    
    WebElement submitElement = waitForElementById("wp-submit");
    submitElement.click();
}

  
  private void insertText(WebElement element, String text)
  {
	  element.clear();
	  element.sendKeys(text);  
  }
  
  private WebElement getWebElementByLinkText(String linkText)
  {
	  return driver.findElement(By.linkText(linkText));
  }
  
  private WebElement getWebElementByXPath(String linkText)
  {
	  return driver.findElement(By.linkText(linkText));
  }
  
  private WebElement getWebElementById(String id)
  {
	  return driver.findElement(By.id(id));
  }
	private WebElement waitForElementByLinkText(String linkText) throws InterruptedException {
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
	
	private WebElement waitForElementById(String id) throws InterruptedException {
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

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private WebElement isElementPresent(By by) {
    try {
      WebElement element = driver.findElement(by);
      return element;
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  
}
