package testautomation;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class SeleniumBase {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void openLogIn() {
		open(baseUrl + "/");
		click(By.linkText("Zaloguj się"));
	}

	private void click(By by) {
		driver.findElement(by).click();
	}

	private void open(String path) {
		driver.get(path);
	}

	protected void logOut() throws InterruptedException {
		click(By.cssSelector("img.gravatar"));
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("(//button[@type='submit'])[2]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		click(By.xpath("(//button[@type='submit'])[2]"));
	}

	protected void logIn(String user, String pass) {
		insertText(user, "user_login");
		insertText(pass, "user_pass");
		click(By.id("wp-submit"));
	}

	private void insertText(String user, String identifier) {
		driver.findElement(By.id(identifier)).clear();
		driver.findElement(By.id(identifier)).sendKeys(user);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}