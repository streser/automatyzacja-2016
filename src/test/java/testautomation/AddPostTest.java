package testautomation;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddPostTest extends SeleniumBase {

	String title;
	
	@Before
	public void generateTitle() {
		title = "Slawek_"+randomName();
	}
	
	@Test
	public void shouldAddPost() throws Exception {
		openLogIn();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		
		click(By.xpath("//div[2]/div/header/a[3]"));
		waitForElement("//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		insertTextByXPath("", "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		insertTextByXPath("Komentarz", "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea");
		insertTextByXPath(title, "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input");
		click(By.xpath("//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]"));
		//waitForElement("//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/span/a");
		waitForElementByLinkText("automatyzacjacs");
		open("https://automatyzacjacs.wordpress.com");
		assertThatPostWasAdded();
		//logOut();
	}
	
	private void assertThatPostWasAdded() throws Exception {
		waitForElementByLinkText(title);
		assertTrue(isElementPresent(By.linkText(title)));
	}
}
