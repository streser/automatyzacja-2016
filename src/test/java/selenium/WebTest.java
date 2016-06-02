package selenium;

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
	public void testSeleniumTestJunit() throws Exception {
		SetupWebTestEnv();
		LoginForWebTest("szkolenieautomatyzacja", "qw12qw12");
	}

	private void SetupWebTestEnv() {
		driver.get(baseUrl + "/");
		driver.findElement(By.className("click-wpcom-login")).click();
		driver.findElement(By.id("user_login")).isDisplayed();
	}

	private void LoginForWebTest(String userID, String userPassword) {
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys(userID);
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys(userPassword);
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
}
