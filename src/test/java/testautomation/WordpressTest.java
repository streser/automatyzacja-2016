package testautomation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WordpressTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://pl.wordpress.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWordpress() throws Exception {
    openLogIn();
    logIn("szkolenieautomatyzacja", "qw12qw12");
    assertThatLogInWasSuccessful();
    logOut();
  }

private void assertThatLogInWasSuccessful() {
	assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
}

private void openLogIn() {
	driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Zaloguj się")).click();
}

private void logOut() throws InterruptedException {
	driver.findElement(By.cssSelector("img.gravatar")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("(//button[@type='submit'])[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
}

private void logIn(String user, String pass) {
	driver.findElement(By.id("user_login")).clear();
    driver.findElement(By.id("user_login")).sendKeys(user);
    driver.findElement(By.id("user_pass")).clear();
    driver.findElement(By.id("user_pass")).sendKeys(pass);
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
