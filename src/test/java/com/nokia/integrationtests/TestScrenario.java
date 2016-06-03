package com.nokia.integrationtests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScrenario {

    	protected WebDriver driver;
    	
	@Before
    	public void setUp() {
    	  driver = new FirefoxDriver();  
    	}
    	
    	
}
