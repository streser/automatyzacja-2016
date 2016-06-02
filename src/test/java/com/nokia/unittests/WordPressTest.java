package com.nokia.unittests;


import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;


public class WordPressTest extends SeleniumBase {
	
  @Test
  public void testAutomation() throws Exception {
    
    //logIn("szkolenieautomatyzacja", "qw12qw12");
    
    //checkLoginSuccessful();
  }

private void checkLoginSuccessful() {
	assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")) != null);
}

@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
}
