package testautomation;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddPostTest extends SeleniumBase {

	private static final String ADD_POST_BUTTON = "//div[2]/div/header/a[3]";
	private static final String LINK_AFTER_POSTING = "//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]";
	private static final String POST_TITLE = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input";
	private static final String POST_COMMENT = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea";
	String title;
	
	@Before
	public void generateTitle() {
		title = "Slawek_"+randomName();
	}
	
	@Test
	public void shouldAddPost() throws Exception {
		openLogIn();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		
		clickAddPost();
		addTextToPost();
		open("https://automatyzacjacs.wordpress.com");
		assertThatPostWasAdded();
		//logOut();
	}

	private void addTextToPost() throws InterruptedException {
		insertTextByXPath("", POST_TITLE);
		insertTextByXPath("Komentarz", POST_COMMENT);
		insertTextByXPath(title, POST_TITLE);
		click(By.xpath(LINK_AFTER_POSTING));
		waitForElementByLinkText("automatyzacjacs");
	}

	private void clickAddPost() throws InterruptedException {
		click(By.xpath(ADD_POST_BUTTON));
		waitForElement(POST_TITLE);
	}
	
	private void assertThatPostWasAdded() throws Exception {
		waitForElementByLinkText(title);
		assertTrue(isElementPresent(By.linkText(title)));
	}
}
