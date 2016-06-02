package testautomation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class WordpressTest extends SeleniumBase {
	@Test
	public void testWordpress() throws Exception {
		openLogIn();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		assertThatLogInWasSuccessful();
		logOut();
	}

	private void assertThatLogInWasSuccessful() {
		assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
	}
}
