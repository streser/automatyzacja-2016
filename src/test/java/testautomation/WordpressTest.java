package testautomation;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WordpressTest {
	private Credentials credentials = new Credentials();
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testWordpress() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Zaloguj się")).click();
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys(credentials.getUser());
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys(credentials.getPassword());
		HtmlHelper.clickElement(driver, "wp-submit");
		driver.findElement(By.cssSelector("img.gravatar")).click();
		HtmlHelper.waitForElement(driver, By.xpath("(//button[@type='submit'])[2]"));
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
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
