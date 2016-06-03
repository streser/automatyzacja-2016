package selenium;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

public class SeleniumBase {

	private static final String BLOG_VIEW_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a/span";
	private static final String BLOG_PUBLISHED_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a/span";
	private static final String BLOG_TEXTAREA_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea";
	private static final String BLOG_TITLE_TXT_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/div/input";
	private static final String BLOG_SUBMIT_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]";
	private static final String BLOG_TEXT_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea";
	private static final String BLOG_TITLE_XPATH = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input";
	private static final String BLOG_HEADER_XPATH = "//div[2]/div/header/a[3]";
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
		InstertTextByID(userID, "user_login");
		InstertTextByID(userPassword, "user_pass");
		MyClick("wp-submit");
	}

	protected void AddNewWebBlogTest(String BlogTitle, String BlogText) throws Exception {

		waitForElement(By.xpath(BLOG_HEADER_XPATH));
		driver.findElement(By.xpath(BLOG_HEADER_XPATH)).click();
		InstertTextByXpath(BlogTitle, BLOG_TITLE_XPATH);
		InstertTextByXpath(BlogText, BLOG_TEXT_XPATH);
		driver.findElement(By.xpath(BLOG_SUBMIT_XPATH)).click();

	}

	protected void VerifyNewWebBlogTest(String BlogTitle, String BlogText) throws Exception {

		waitForElement(By.xpath(BLOG_PUBLISHED_XPATH));
		driver.findElement(By.xpath(BLOG_TITLE_TXT_XPATH)).click();
		// TODO verify BlogTitle
		driver.findElement(By.xpath(BLOG_TEXTAREA_XPATH)).click();
		// TODO verify BlogText
		waitForElement(By.xpath(BLOG_VIEW_XPATH));
		//driver.findElement(By.xpath(BLOG_VIEW_XPATH)).click();

	}
	
	public String randomName() {
		return UUID.randomUUID().toString();
	}

	public void waitForElement(By locator) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(locator))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
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

	private void InstertTextByID(String InputText, String FieldID) {
		driver.findElement(By.id(FieldID)).clear();
		driver.findElement(By.id(FieldID)).sendKeys(InputText);
	}

	private void InstertTextByXpath(String InputText, String FieldID) {
		driver.findElement(By.xpath(FieldID)).click();
		driver.findElement(By.xpath(FieldID)).sendKeys(InputText);
		driver.findElement(By.xpath(FieldID)).click();
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