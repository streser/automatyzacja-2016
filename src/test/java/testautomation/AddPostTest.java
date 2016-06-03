package testautomation;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddPostTest extends SeleniumBase {

	private static final String ADD_NEW_POST = "//div[2]/div/header/a[3]";
	private static final String PUBLISH = "//div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]";
	private static final String COMMENT_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea";
	private static final String TITLE_FIELD = "//div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input";
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
		insertTextByXPath("", TITLE_FIELD);
		insertTextByXPath("Komentarz", COMMENT_FIELD);
		insertTextByXPath(title, TITLE_FIELD);
		click(By.xpath(PUBLISH));
		waitForElementByLinkText("automatyzacjacs");
	}

	private void clickAddPost() throws InterruptedException {
		click(By.xpath(ADD_NEW_POST));
		waitForElement(TITLE_FIELD);
	}
	
	private void assertThatPostWasAdded() throws Exception {
		waitForElementByLinkText(title);
		assertTrue(isElementPresent(By.linkText(title)));
	}
}
