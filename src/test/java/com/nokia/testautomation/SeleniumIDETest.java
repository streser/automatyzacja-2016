package com.nokia.testautomation;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIDETest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://pl.wordpress.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelen() throws Exception {
    logIn("szkolenieautomatyzacja", "qw12qw12");
    logOut();
  }

public void logOut() throws InterruptedException {
	driver.findElement(By.cssSelector("img.gravatar")).click();
	By logoutButton = By.xpath("(//button[@type='submit'])[2]");
    waitForElement(logoutButton);
    driver.findElement(logoutButton).click();
}

public void waitForElement(By byElem) throws InterruptedException {
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(byElem)) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
}

public void logIn(String login, String password) {
	driver.get(baseUrl + "/");
	driver.findElement(By.className("click-wpcom-login")).click();
    driver.findElement(By.id("user_login")).clear();
    driver.findElement(By.id("user_login")).sendKeys(login);
    driver.findElement(By.id("user_pass")).clear();
    driver.findElement(By.id("user_pass")).sendKeys(password);
    driver.findElement(By.id("wp-submit")).click();
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
