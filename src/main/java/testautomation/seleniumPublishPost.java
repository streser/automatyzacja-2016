package testautomation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class seleniumPublishPost extends seleniumSuperClass {

	@Test
	public void shouldPublishPost() throws Exception {
		final String INPUT_TEXT = "justtesting";
		driver.get(baseUrl + "/");
		logIn("szkolenieautomatyzacja", "qw12qw12");
		click(By.className("masterbar__item-new"));
		insertText(By.className("form-text-input"), INPUT_TEXT);
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.className("notice__action"));
//		click(By.className("notice__action"));
		// waitForElement(By.className("entry-title"));
		// String
		// publishedText=driver.findElement(By.className("entry-title")).getText();
		
		driver.get("https://automatyzacjacs.wordpress.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {
			
			public boolean apply(WebDriver arg0) {
				return driver.getPageSource().contains(INPUT_TEXT);
			}
		});
		
		driver.close();
	}
}
