package selenium;

import org.junit.*;
import org.openqa.selenium.*;

public class WebTest extends SeleniumBase {
	WebDriver driver;
	String baseUrl;

	@Test
	public void testSeleniumTestJunit() throws Exception {
		SetupWebTestEnv();
		LoginForWebTest("szkolenieautomatyzacja", "qw12qw12");
		String BlogID = randomName();
		AddNewWebBlogTest("BlogTitle by edmundb. ID: " + BlogID, "BlogText by edmundb. ID: " + BlogID);
		VerifyNewWebBlogTest("BlogTitle by edmundb. ID: " + BlogID, "BlogText by edmundb. ID: " + BlogID);
	}
}
