package com.nokia.testautomation.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page 
{
	protected WebDriver driver;	
	
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
			    	if (second >= 60) return null;
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
	    	if (second >= 60) return null;
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
	    	if (second >= 60) return null;
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

}
