package com.nokia.testautomation;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIDETest {
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
  public void testSelen() throws Exception {
	openLogInForm();
    logIn("szkolenieautomatyzacja", "qw12qw12");
    assertThatLogInWasSuccesful();
    logOut();
  }

public void assertThatLogInWasSuccesful() {
	assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
}

public void logOut() throws InterruptedException {
	driver.findElement(By.cssSelector("img.gravatar")).click();
	By logoutButton = By.xpath("(//button[@type='submit'])[2]");
    waitForElement();
    driver.findElement(logoutButton).click();
}

public void waitForElement() throws InterruptedException {
	for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("(//button[@type='submit'])[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
}

public void logIn(String login, String password) {
	
    driver.findElement(By.id("user_login")).clear();
    driver.findElement(By.id("user_login")).sendKeys(login);
    driver.findElement(By.id("user_pass")).clear();
    driver.findElement(By.id("user_pass")).sendKeys(password);
    driver.findElement(By.id("wp-submit")).click();
}
public void openLogInForm(){
	driver.get(baseUrl + "/");
	driver.findElement(By.className("click-wpcom-login")).click();
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
