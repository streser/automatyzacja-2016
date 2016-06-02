package testautomation;

import static org.junit.Assert.fail;

import java.util.UUID;
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

	protected void click(By by) {
		driver.findElement(by).click();
	}

	protected void open(String path) {
		driver.get(path);
	}

	protected void logOut() throws InterruptedException {
		click(By.cssSelector("img.gravatar"));
		waitForElement("(//button[@type='submit'])[2]");
		click(By.xpath("(//button[@type='submit'])[2]"));
	}

	protected void waitForElement(String path) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath(path)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	
	protected void waitForElementByLinkText(String path) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.linkText(path)))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	protected void logIn(String user, String pass) {
		insertText(user, "user_login");
		insertText(pass, "user_pass");
		click(By.id("wp-submit"));
	}
	
	public String randomName() {
		return UUID.randomUUID().toString();
	}

	private void insertText(String user, String identifier) {
		driver.findElement(By.id(identifier)).clear();
		driver.findElement(By.id(identifier)).sendKeys(user);
	}
	
	public void insertTextByXPath(String text, String identifier) {
		driver.findElement(By.xpath(identifier)).clear();
		driver.findElement(By.xpath(identifier)).sendKeys(text);
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