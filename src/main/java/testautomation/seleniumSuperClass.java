package testautomation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumSuperClass {

	protected WebDriver driver;
	private String baseUrl;
	protected StringBuffer verificationErrors = new StringBuffer();

	public seleniumSuperClass() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void shouldLogIn() throws Exception {
		driver.get(baseUrl + "/");
		logIn("szkolenieautomatyzacja", "qw12qw12");
	}

	private void logIn(String login, String password) {
		driver.findElement(By.linkText("Zaloguj się")).click();
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys(login);
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// name=oktab04184930043155366 | ]]
		assertEquals("Obserwowanie ‹ Reader — WordPress.com", driver.getTitle());
	}

	protected boolean isElementPresent(By xpath) {
		// TODO 
		return true;
	}

}