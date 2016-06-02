package testautomation;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
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
		logOut();
	}

	private void insertText(By element, String text) {
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(text);
	}

	private void logIn(String login, String password) {
		// driver.findElement(By.linkText("Zaloguj się")).click();
		driver.findElement(By.className("click-wpcom-login")).click();

		insertText(By.id("user_login"), login);
		insertText(By.id("user_pass"), password);

		driver.findElement(By.id("wp-submit")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// name=oktab04184930043155366 | ]]
		assertEquals("Obserwowanie ‹ Reader — WordPress.com", driver.getTitle());
	}
	
	private void logOut(){
	    driver.findElement(By.cssSelector("img.gravatar")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab8235637659710296 | ]]
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();	
	}

	protected boolean isElementPresent(By xpath) {
		try {
			driver.findElement(xpath);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}