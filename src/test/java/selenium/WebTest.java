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
		BlogWebTest("BlogTitle by edmundb", "BlogText by edmundb");
	}
}
