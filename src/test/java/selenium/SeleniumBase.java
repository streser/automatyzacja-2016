package selenium;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

public class SeleniumBase {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	public SeleniumBase() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://pl.wordpress.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void SetupWebTestEnv() {
		driver.get(baseUrl + "/");
		driver.findElement(By.className("click-wpcom-login")).click();
		driver.findElement(By.id("user_login")).isDisplayed();
	}

	protected void LoginForWebTest(String userID, String userPassword) {
		MyInstertText(userID, "user_login");
		MyInstertText(userPassword, "user_pass");
		MyClick("wp-submit");
	}

	private void MyInstertText(String InputText, String FieldID) {
		driver.findElement(By.id(FieldID)).clear();
		driver.findElement(By.id(FieldID)).sendKeys(InputText);
	}

	private void MyClick(String IdentyfyID) {
		driver.findElement(By.id(IdentyfyID)).click();
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