package com.nokia.unittests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://pl.wordpress.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWeb() throws Exception {
    driver.get(baseUrl + "/");
    logIn("Zaloguj się","user_login","szkolenieautomatyzacja","user_pass","qw12qw12");
    driver.findElement(By.id("rememberme")).click();
    driver.findElement(By.id("wp-submit")).click();
    driver.findElement(By.cssSelector("img.gravatar")).click();
    waitForElement("description");
    inputText("description", "1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
  }

private void inputText(String elementId, String elementValue) {
	driver.findElement(By.id(elementId)).clear();
    driver.findElement(By.id(elementId)).sendKeys(elementValue);
}

private void logIn(String linkText, String userElementId, String user, String passwordElementId, String password) {
    driver.findElement(By.linkText(linkText)).click();
	inputText(userElementId, user);
    inputText(passwordElementId, password);
}

private void waitForElement(String elementId) throws InterruptedException {
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id(elementId))) break; } catch (Exception e) {}
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

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
