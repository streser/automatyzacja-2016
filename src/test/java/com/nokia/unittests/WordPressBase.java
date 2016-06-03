package com.nokia.unittests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class WordPressBase 
{
	protected WebDriver driver;
	
	protected void init()
	{
		driver = new FirefoxDriver();
	}
}
